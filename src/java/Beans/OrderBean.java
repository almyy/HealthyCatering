package Beans;

import DB.Database;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import logikk.Dish;
import logikk.Order;
import logikk.User;
import org.primefaces.event.SelectEvent;

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
    private Date currentDate = new Date();
    private int[] hourvalues = {10, 11, 12, 13, 14, 15, 16, 17};
    private int[] minutevalues = {00, 10, 20, 30, 40, 50};
    private String description;
    private double total_price;
    private Order savedOrder;

    public OrderBean() {
        MenuItems menuitems = getMenuItems();
        total_price = menuitems.getTotal_price();
    }

    public String confirmOrder() {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correct", "Correct");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        Order order = new Order(deliverydate, user.getAddress(), 7, dishes, description, user.getPostnumber(), total_price);
        String returnvalue = "";
        if (db.order(order)) {
            MenuItems menuitems = getMenuItems();
            menuitems.getOrderList().clear();
            FacesContext facesContext = FacesContext.getCurrentInstance();
            if (facesContext != null) {
                try {
                    if (db.getRole().equals("customer") || db.getRole().equals("salesman")) {
                        returnvalue = "orderSuccess.xhtml";
                    }
                } catch (Exception e) {
                    System.out.println("IOException");
                }
            }
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error, try again later.", "Error, try again later.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            returnvalue = "order.xhtml";
        }
        return returnvalue;
    }

    public String subscribe() {
        savedOrder = new Order(deliverydate, user.getAddress(), 7, dishes, description, user.getPostnumber(), total_price);
        return "subscriptionplan.xhtml";
    }

    public ArrayList<Dish> fillDishes() {
        MenuItems menuitems = getMenuItems();
        ArrayList<Dish> items = menuitems.getOrderList();
        return items;
    }

    public TimeZone getTimeZone() {
        TimeZone tz = TimeZone.getDefault();
        return tz;
    }

    public void handleDateSelect(SelectEvent event) {
        System.out.println("YOLO");
        FacesContext facesContext = FacesContext.getCurrentInstance();  
        SimpleDateFormat format = new SimpleDateFormat("d/M/yyyy");
        deliverydate = new Date(format.format(event.getObject()));
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));  
    }  

    public MenuItems getMenuItems() {
        FacesContext context = FacesContext.getCurrentInstance();
        MenuItems menuitems = (MenuItems) context.getApplication().evaluateExpressionGet(context, "#{menuitems}", MenuItems.class);
        return menuitems;
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

    public int[] getMinutevalues() {
        return minutevalues;
    }

    public void setMinutevalues(int[] minutevalues) {
        this.minutevalues = minutevalues;
    }

    public int[] getHourvalues() {
        return hourvalues;
    }

    public void setHourvalues(int[] hourvalues) {
        this.hourvalues = hourvalues;
    }

    public Order getSavedOrder() {
        return savedOrder;
    }

    public Date getCurrentDate() {
        currentDate = new Date();
        return currentDate;
    }
    
    
}
