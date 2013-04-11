/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logikk;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

public class OrderStatus{
    
    private Order order;
    
    public OrderStatus(){   
        order = new Order();
        
    }
    public OrderStatus(Order order){
        this.order = order;
        
    }
    public Order getOrder() {
        return order;
    }
 
    public void setOrder(Order newOrder){
        this.order = newOrder; 
    }    
}