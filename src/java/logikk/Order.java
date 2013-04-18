package logikk;
/*
 * Class for generating orders from customerinput.
 */

import DB.Database;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class Order {

    private Date fullDate;
    private int orderId;
    private Date date;
    private Time timeOfDelivery;
    private String deliveryAddress;
    private String status;
    private int status_numeric;
    private ArrayList<Dish> orderedDishes = new ArrayList();
    private double orderPrice = 0.0;
    private String description;
    private int postalcode; 
    private double totalprice = 0.0;
    private Database DB;
    

    public Order() {
        
    }

    public Order(Date date, Time timeOfDelivery, String deliveryAddress) {
        fullDate = new Date(date.getYear(), date.getMonth(), date.getDate(),
                timeOfDelivery.getHours(), timeOfDelivery.getMinutes(), timeOfDelivery.getSeconds());
        this.date = date;
        this.timeOfDelivery = timeOfDelivery;
        this.deliveryAddress = deliveryAddress;
        this.status = Status.NULL.toString();
    }

    public Order(Date date, Time timeOfDelivery, String deliveryAddress, int status) {
        fullDate = new Date(date.getYear(), date.getMonth(), date.getDate(),
                timeOfDelivery.getHours(), timeOfDelivery.getMinutes(), timeOfDelivery.getSeconds());
        this.date = date;
        this.timeOfDelivery = timeOfDelivery;
        this.deliveryAddress = deliveryAddress;
        status_numeric = status;
        this.status=Status.getStatusName(status);
    }
    public Order(Date date, Time timeOfDelivery, String deliveryAddress, int status,double totalPrice) {
        fullDate = new Date(date.getYear(), date.getMonth(), date.getDate(),
                timeOfDelivery.getHours(), timeOfDelivery.getMinutes(), timeOfDelivery.getSeconds());
        this.date = date;
        this.timeOfDelivery = timeOfDelivery;
        this.deliveryAddress = deliveryAddress;
        status_numeric = status;
        this.totalprice = totalPrice; 
        this.status=Status.getStatusName(status);
    }

    public Order(Date date, String deliveryAddress, int status, ArrayList<Dish> dishes, String description, int postalcode, double totalprice) {
        fullDate = new Date(date.getYear(), date.getMonth(), date.getDate(),
                date.getHours(), date.getMinutes(), date.getSeconds());
        this.date = date;
        this.deliveryAddress = deliveryAddress;
        status_numeric = status;
        this.orderedDishes = dishes;
        this.description = description;
        this.postalcode = postalcode;
        this.totalprice = totalprice;
    }
    
    public String getStatus() {
        return status;
    }

    public int getStatusNumeric() {
        return status_numeric;
    }

    public void setStatus_numeric(int status_numeric) {
        this.status_numeric = status_numeric;
    }

    public void setStatus(String status) {
        this.status = status;
        System.out.println(status);
        if (status.equals(Status.PENDING.toString())) {
            this.status_numeric = 1;
        } else if (status.equals(Status.UNDER_PREPARATION.toString())) {
            this.status_numeric = 2;
        } else if (status.equals(Status.PENDING_DELIVERY.toString())) {
            this.status_numeric = 3;
        } else if (status.equals(Status.ON_THE_ROAD.toString())) {
            this.status_numeric = 4;
        } else if (status.equals(Status.FINISHED.toString())) {
            this.status_numeric = 5;
        } else if (status.equals(Status.MISSING.toString())) {
            this.status_numeric = 6;
        } else if (status.equals(Status.NEEDS_APPROVAL.toString())) {
            this.status_numeric = 7;
        }
        System.out.println(status_numeric);
    }

    public boolean addDish(Dish dish) {
        if (dish == null) {
            return false;
        }
        for (int i = 0; i < dish.getCount(); i++) {
            orderedDishes.add(dish);
            orderPrice += dish.getPrice();
        }
        return true;
    }

    public Date getFullDate() {
        return fullDate;
    }

    public ArrayList<Dish> getOrderedDish() {
        return orderedDishes;
    }

    public Date getDate() {
        return date;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public int getOrderId() {
        return orderId;
    }

    public Time getTimeOfDelivery() {
        return timeOfDelivery;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTimeOfDelivery(Time timeOfDelivery) {
        this.timeOfDelivery = timeOfDelivery;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(int postalcode) {
        this.postalcode = postalcode;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalPrice(double totalprice) {
        this.totalprice = totalprice;
    }   
    
}
