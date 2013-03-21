package logikk;
/*
 * Class for generating orders from customerinput. 
 */
import java.sql.Date;
import java.util.ArrayList;

public class Order {

    private Date fullDate;
    private int orderId;
    private Date timeOfDelivery;
    private String deliveryAddress;
    private String status;
    private int status_numeric;
    private ArrayList<Dish> orderedDish = new ArrayList();
    private double orderPrice = 0.0;
    private String description;
    private int postalcode;

    public Order(){
        
    }
    public Order(Date timeOfDelivery, String deliveryAddress) {
        this.timeOfDelivery = timeOfDelivery;
        this.deliveryAddress = deliveryAddress;
        this.status = Status.NULL.toString();
    }

    public Order(Date timeOfDelivery, String deliveryAddress, int status) {
        this.timeOfDelivery = timeOfDelivery;
        this.deliveryAddress = deliveryAddress;
        status_numeric = status; 
        switch (status) {
            case 1:
                this.status = Status.PENDING.toString();
                break;
            case 2:
                this.status = Status.UNDER_PREPARATION.toString();
                break;
            case 3:
                this.status = Status.PENDING_DELIVERY.toString();
                break;
            case 4:
                this.status = Status.ON_THE_ROAD.toString();
                break;
            case 5:
                this.status = Status.FINISHED.toString();
                break;
            case 6:
                this.status = Status.MISSING.toString();
                break;
            case 7:
                this.status = Status.NEEDS_APPROVAL.toString();
                break;
        }
    }
    
    public Order(Date timeOfDelivery, String deliveryAddress, int status, ArrayList<Dish> dishes, String description) {
        this.timeOfDelivery = timeOfDelivery;
        this.deliveryAddress = deliveryAddress;
        status_numeric = status; 
        this.orderedDish = dishes;
        this.description = description;
        this.postalcode = postalcode;
        switch (status) {
            case 1:
                this.status = Status.PENDING.toString();
                break;
            case 2:
                this.status = Status.UNDER_PREPARATION.toString();
                break;
            case 3:
                this.status = Status.PENDING_DELIVERY.toString();
                break;
            case 4:
                this.status = Status.ON_THE_ROAD.toString();
                break;
            case 5:
                this.status = Status.FINISHED.toString();
                break;
            case 6:
                this.status = Status.MISSING.toString();
                break;
            case 7:
                this.status = Status.NEEDS_APPROVAL.toString();
                break;
        }
    }

    public int getPostalcode() {
        return postalcode;
    }
    
    public String getStatus() {
        return status;
    }
    public int getStatusNumeric(){
        return status_numeric;
    }
    public void setStatus_numeric(int status_numeric) {
        this.status_numeric = status_numeric;
    }
    public void setStatus(String status) {
        this.status = status;
        if(status.equals(Status.PENDING.toString())){
            this.status_numeric=1;
        }
        else if(status.equals(Status.UNDER_PREPARATION.toString())){
            this.status_numeric=2;
        }
        else if(status.equals(Status.PENDING_DELIVERY.toString())){
            this.status_numeric=3;
        }
       
    }
   
    public boolean addDish(Dish dish) {
        if (dish == null) {
            return false;
        }
        for (int i = 0; i < dish.getCount(); i++) {
            orderedDish.add(dish);
            orderPrice += dish.getPrice();
        }
        return true;
    }

    public Date getFullDate() {
        return fullDate;
    }
    
    public ArrayList<Dish> getOrderedDish() {
        return orderedDish;
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

    public Date getTimeOfDelivery() {
        return timeOfDelivery;
    }   
    
    public void setTimeOfDelivery(Date timeOfDelivery) {
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
}
