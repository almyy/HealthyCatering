/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Java.Order;
import Java.OrderStatus;
import Java.PendingOrders;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

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

    public synchronized void update() {
        ArrayList<Order> temp = overView.getOrders();
        if (tabelldata.size() < temp.size()) {
            for (int i = 0; i < temp.size(); i++) {
                Order temporaryTestOrder = temp.get(i);
                temporaryTestOrder.addDish(new Java.Dish(2, "laks", 100.95, 1));
                temporaryTestOrder.addDish(new Java.Dish(3, "biff", 300.95, 4));
                tabelldata.add(new OrderStatus(temp.get(i)));
            }
        }
    }
}
