/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import DB.Database;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import logikk.Order;
import logikk.OrderStatus;
import logikk.PendingOrders;
import java.io.Serializable;
import java.sql.SQLException;
import logikk.SubscriptionPlan;

/**
 *
 * @author Frode
 */
@SessionScoped
@Named("Admin")
public class AdminBean implements Serializable {
    private Database db = new Database();
    private List<OrderStatus> tabledata = Collections.synchronizedList(new ArrayList<OrderStatus>());
    private Order tempOrder = new Order();
    private ArrayList<SubscriptionPlan> deletedplans = new ArrayList<SubscriptionPlan>();

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
    
    public void deletePlans(){
        ArrayList<SubscriptionPlan> temp = db.removeOrder();
        System.out.println("size: " + temp.size());
        for(int i=0; i<temp.size(); i++){
            deletedplans.add(temp.get(i));
        }
    }
    public void updatePlans(){
            db.checkSubscription();
    }

    public ArrayList<SubscriptionPlan> getDeletedplans() {
        return deletedplans;
    }
    
    public boolean deletedExists(){
        return deletedplans.size() > 0;
    }
}
