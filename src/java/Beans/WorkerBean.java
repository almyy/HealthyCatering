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
/**
 *
 * @author Rino
 */
@SessionScoped
@Named("Chef")
public class WorkerBean implements Serializable {
    private List<Order> tabelldata = Collections.synchronizedList(new ArrayList<Order>());
}
