/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logikk;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

public class OrderStatus implements Serializable{
    
    private Order order;
    private boolean toBeChanged;
    private boolean toBeDeleted;
    private UIComponent uic;
    
    public OrderStatus(){   
        order = new Order();
        toBeChanged=false;
        toBeDeleted = false;
    }
    public OrderStatus(Order order){
        this.order = order;
        toBeChanged = false;
        toBeDeleted = false; 
    }
    public void setToBeChangedFalse(){
        toBeChanged = false; 
    }
    public Order getOrder() {
        return order;
    }
    public boolean getToBeChanged(){
        return toBeChanged;
    }
    public boolean getToBeDeleted(){
        return toBeDeleted;
    }
    public void setToBeChanged(){
        toBeChanged = !toBeChanged;
        System.out.println("FITTE");
    }
    public void setToBeDeleted(boolean newToBeDeleted){
        toBeDeleted = newToBeDeleted; 
    }
    public void setOrder(Order newOrder){
        this.order = newOrder; 
    }

    public UIComponent getUic() {
        return uic;
    }

    public void setUic(UIComponent uic) {
        this.uic = uic;
    }
    
}