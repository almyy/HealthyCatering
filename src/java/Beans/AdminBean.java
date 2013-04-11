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

/**
 *
 * @author Frode
 */
@SessionScoped
@Named("Admin")
public class AdminBean implements Serializable {
    private List<OrderStatus> tabledata = Collections.synchronizedList(new ArrayList<OrderStatus>());
    private Order tempOrder = new Order();

     public AdminBean(){
        
        
    }
     public synchronized boolean getDataExist() {
        return (tabledata.size() > 0);
    }

    public List<OrderStatus> getTabledata() {
        return tabledata;
    }

    public Order getTempOrder() {
        return tempOrder;
    }
     
}
