package Java;

import DB.Database;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Michael
 */
@Named("menuitems")
@SessionScoped
public class MenuItems implements Serializable{

    Database db = new Database();
    ArrayList<Dish> items = fillTable();
    ArrayList<Dish> orderList = new ArrayList<Dish>();
    int count;
    private Dish selectedDish;
    
    
    public ArrayList<Dish> fillTable(){
        try{
        return db.getDishes();
        } catch(Exception e){
            System.out.println("Error");
        }
        return new ArrayList<Dish>();
    }
    
    public Dish getSelectedDish(){
        return selectedDish;
    }
    
    public void setSelectedDish(Dish dish){
        this.selectedDish = dish;
    }
    public void addDish(){
        Dish newDish = new Dish(selectedDish.getDishId(), selectedDish.getDishName(), selectedDish.getPrice(),
                selectedDish.getCount());
        orderList.add(newDish);
    }
    
    public void removeDish(Dish dish){
        orderList.remove(dish);
    }
    
    public ArrayList<Dish> getItems() {
        return items;
    }
    public ArrayList<Dish> getOrderList(){
        return orderList;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
