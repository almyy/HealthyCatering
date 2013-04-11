/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import logikk.Order;
import logikk.OrderStatus;
import logikk.PendingOrders;
import java.io.Serializable;
import logikk.OrderStatus;
import logikk.Orders;

/**
 *
 * @author Frode
 */
@SessionScoped
@Named("Admin")
public class AdminBean implements Serializable {
    private Orders orders = new Orders();
    private List<OrderStatus> tabledata = Collections.synchronizedList(new ArrayList<OrderStatus>());    
     public AdminBean(){
         if(orders.getList()!=null){
             for(int i = 0;i<orders.getList().size();i++){
                 tabledata.add(new OrderStatus(orders.getList().get(i)));
             }
         }
        
        
    }

    public synchronized List<OrderStatus> getTabledata() {
        return tabledata;
    }

    public synchronized Orders getOrders() {
        return orders;
    }

    
    
     
}
