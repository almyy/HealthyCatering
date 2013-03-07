/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import Java.Order;
import Java.OrderStatus;
import Java.PendingOrders;
/**
 *
 * @author Rino
 */
@SessionScoped
@Named("Worker")
public class WorkerBean implements Serializable {
    private PendingOrders overView = new PendingOrders(); 
    private List<OrderStatus> tabelldata = Collections.synchronizedList(new ArrayList<OrderStatus>());
    
    public synchronized List<OrderStatus> getTabelldata() {
        return tabelldata;
    }
    public synchronized boolean isEmpty() {
        return !(tabelldata.size() > 0);
    }
    public synchronized void update(){
        ArrayList<Order> temp = overView.getOrders();

        if(tabelldata.size() < temp.size()){
            for(int i = 0; i < temp.size(); i++){
                tabelldata.add(new OrderStatus(temp.get(i)));
            }
        }
    }
}
