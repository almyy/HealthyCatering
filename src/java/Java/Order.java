package Java;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Order {

    public enum Status {
        PENDING, UNDER_PREPARATION, PENDING_DELIVERY, ON_THE_ROAD, FINISHED, MISSING;
    }

    private int orderId;
    private Date date;
    private int timeOfDelivery;
    private String deliveryAddress;
    private Status status;
    private ArrayList<Dish> orderedDish = new ArrayList();
    private double orderPrice = 0.0;

    private static final AtomicInteger sequence = new AtomicInteger(); //making an unique id atomically.
    
    public Order(){
        this.orderId=sequence.getAndIncrement();
    }
    
    public Order(Date date, int timeOfDelivery, String deliveryAddress) {
        this.orderId = sequence.getAndIncrement();
        this.date = date;
        this.timeOfDelivery = timeOfDelivery;
        this.deliveryAddress = deliveryAddress;
    }
    public boolean addDish(Dish dish, int count){
        if(dish==null){return false;}
        for(int i = 0; i < count; i++){
            orderedDish.add(dish);
            orderPrice+=dish.getPrice();
        }
        return true;
    }

    public ArrayList<Dish> getOrderedDish() {
        return orderedDish;
    }
    
    public Date getDate() {
        return date;
    }
    private void setStatus(Status newStatus){
        this.status=newStatus; 
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public Status getStatus() {
        return status;
    }
    

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getTimeOfDelivery() {
        return timeOfDelivery;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTimeOfDelivery(int timeOfDelivery) {
        this.timeOfDelivery = timeOfDelivery;
    }
    
}
