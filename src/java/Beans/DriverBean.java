package Beans;

import Java.Order;
import Java.OrderStatus;
import Java.Orders;
import Java.PendingOrders;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Frode
 */
@SessionScoped
@Named("Driver")
public class DriverBean implements Serializable {
     private Orders orders = new Orders();
    private List<OrderStatus> tabledata = Collections.synchronizedList(new ArrayList<OrderStatus>());
    private Order tempOrder = new Order();

    public DriverBean(){
        if(orders.getDriversList()!=null){
            ArrayList<Order>liste = orders.getDriversList();
            for(int i = 0;i<liste.size();i++){
                tabledata.add(new OrderStatus(liste.get(i)));
            }
        }
    }
     public synchronized boolean getDataExist() {
        return (tabledata.size() > 0);
    }

    public Orders getOrders() {
        return orders;
    }

    public List<OrderStatus> getTabledata() {
        return tabledata;
    }

    public Order getTempOrder() {
        return tempOrder;
    }
     
}


