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
/**
 *
 * @author Rino
 */
@SessionScoped
@Named("Worker")
public class WorkerBean implements Serializable {
    private List<OrderStatus> tabelldata = Collections.synchronizedList(new ArrayList<OrderStatus>());
    
    public synchronized List<OrderStatus> getTabelldata() {
        return tabelldata;
    }
    public synchronized boolean isEmpty() {
        return !(tabelldata.size() > 0);
    }
}
