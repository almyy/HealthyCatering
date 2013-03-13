package Java;

/**
 *
 * @author Rino
 */
public class Dish {

    private int dishId;
    private String dishName;
    private double price;
    private int count; 

    public Dish(int dishId, String dishName, double price) {
        this.dishId = dishId;
        this.dishName = dishName;
        this.price = price;
        this.count = 1;
    }
    public Dish(int dishId, String dishName, double price,int count) {
        this.dishId = dishId;
        this.dishName = dishName;
        this.price = price;
        this.count = count; 
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
    public int getDishId() {
        return dishId;
    }

    public String getDishName() {
        return dishName;
    }

    public double getPrice() {
        return price;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public String toString(){
        return dishName;
    }
}
