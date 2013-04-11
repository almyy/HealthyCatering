/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logikk;

import DB.Database;
import java.util.ArrayList;

/**
 *
 * @author Frode
 */
public class Orders {
    private ArrayList<Order>list;
    private Database database = new Database();
    
    public Orders(){
        this.list = database.getOrderOverview();
    }

    public ArrayList<Order> getList() {
        return list;
    }
    
    
}
