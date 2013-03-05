
package Java;

/**
 *
 * @author Rino
 */
class Dish {
    private int dishId;
    private String dishName; 
    private double price;
    
    public Dish(int dishId,String dishName, double price){
        this.dishId = dishId;
        this.dishName = dishName;
        this.price = price;
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
}
