/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import DB.Database;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import logikk.User;

/**
 *
 * @author Michael
 */
@Named(value = "orderBean")
@SessionScoped
public class OrderBean implements Serializable{
    private Database db = new Database();
    private User user = db.getUser();
    private int selected = 1;
    private Date deliverydate;
    private Time time;

    public Time getTime() {
        return time;
    }

    public Date getDeliverydate() {
        return deliverydate;
    }

    public void setDeliverydate(Date deliverydate) {
        this.deliverydate = deliverydate;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }
    
    
    
    
    

}
