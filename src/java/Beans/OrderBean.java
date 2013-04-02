
package Beans;

import DB.Database;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import logikk.Dish;
import logikk.MenuItems;
import logikk.Order;
import logikk.User;

/**
 *
 * @author Michael
 */
@Named(value = "orderBean")
@SessionScoped
public class OrderBean implements Serializable {

    private Database db = new Database();
    private ArrayList<Dish> dishes = fillDishes();
    private User user = db.getUser();
    private Date deliverydate = new Date();
    private String description;
    private double total_price;

    public OrderBean() {
        deliverydate.setHours(10);
        deliverydate.setMinutes(00);
    }

    public String confirmOrder() {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correct", "Correct");  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
        java.sql.Date sqlDate = new java.sql.Date(deliverydate.getTime());
        Order order = new Order(sqlDate, user.getAddress(), dishes, description, user.getPostnumber());
        String returnvalue = "";
        if (db.order(order)) {
            FacesContext context = FacesContext.getCurrentInstance();
            MenuItems menuitems = (MenuItems) context.getApplication().evaluateExpressionGet(context, "#{menuitems}", MenuItems.class);
            menuitems.getOrderList().clear();
            FacesContext facesContext = FacesContext.getCurrentInstance();
            if (facesContext != null) {
                try {
                    if (facesContext.getExternalContext()
                            .getUserPrincipal().getName().equals("customer")) {
                        returnvalue = "orderSuccess.xhtml";
                    } 
                } catch (Exception e) {
                    System.out.println("IOException");
                }
            }
        }
        return returnvalue;
    }

    public ArrayList<Dish> fillDishes() {
        FacesContext context = FacesContext.getCurrentInstance();
        MenuItems menuitems = (MenuItems) context.getApplication().evaluateExpressionGet(context, "#{menuitems}", MenuItems.class);
        ArrayList<Dish> items = menuitems.getOrderList();
        return items;
    }
    
    public TimeZone getTimeZone() {
        TimeZone tz = TimeZone.getDefault();
        return tz;
    }

    public double getTotal_price() {
        total_price = 0.0;
        for (int i = 0; i < dishes.size(); i++) {
            total_price += dishes.get(i).getPrice() * dishes.get(i).getCount();
        }
        return total_price;
    }

    public ArrayList<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(ArrayList<Dish> dishes) {
        this.dishes = dishes;
    }

    public Date getDeliverydate() {
        return deliverydate;
    }

    public void setDeliverydate(Date deliverydate) {
        this.deliverydate = deliverydate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
