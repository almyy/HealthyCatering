/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package Beans;

import logikk.Order;
import logikk.OrderStatus;
import logikk.PendingOrders;
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
    private List<OrderStatus> tabledata = Collections.synchronizedList(new ArrayList<OrderStatus>());

    public synchronized List<OrderStatus> getTabledata() {
        return tabledata;
    }

    public synchronized boolean isEmpty() {
        return !(tabledata.size() > 0);
    }

    public synchronized void update() {
        ArrayList<Order> temp = overView.getFirstOrders();
        if (tabledata.size() < temp.size()) {
            tabledata.clear();
            for (int i = 0; i < temp.size(); i++) {
                tabledata.add(new OrderStatus(temp.get(i)));
            }
        }
        for(int i = 0; i < tabledata.size();i++){
            if(tabledata.get(i).getOrder().getStatusNumeric()!=temp.get(i).getStatusNumeric()){
                overView.updateDb(tabledata.get(i).getOrder());
            }
        }
    }
}