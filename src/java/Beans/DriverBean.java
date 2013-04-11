package Beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import logikk.Order;
import logikk.OrderStatus;

/**
 *
 * @author Frode
 */
@SessionScoped
@Named("Driver")
public class DriverBean implements Serializable {
    private List<OrderStatus> tabledata = Collections.synchronizedList(new ArrayList<OrderStatus>());
    private Order tempOrder = new Order();

    public DriverBean(){

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