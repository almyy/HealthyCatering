/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Java;

import DB.Database;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Rino
 */

public class PendingOrders implements Serializable{
    private Database database = new Database();
    private ArrayList<Order> orders = new ArrayList();
    
    public PendingOrders(){
        String query = "Select * from ASD.ORDERS where STATUS !=5"; //Status nr 5 means FINISHED
        orders = database.getPendingOrders(query);
    }
    public ArrayList<Order> getOrders(){
        return orders; 
    }
    public void updateDb(Order s){
        database.updateOrder(s);
    }
}