package Beans;

import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value = "subBean")
@SessionScoped
public class SubscribeBean implements Serializable{

    private ArrayList selectedDays = new ArrayList();
    private String[] weekdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
    private Time mondaytime = new Time(10, 10, 0);
    private Time tuesdaytime = new Time(10, 10, 0);
    private Time wednesdaytime = new Time(10, 10, 0);
    private Time thursdaytime = new Time(10, 10, 0);
    private Time fridaytime = new Time(10, 10, 0);
    private Date startdate = new Date();
    private Date enddate = new Date();

    public String submitPlan(){
        String returnvalue = "";
        
        return returnvalue;
    }
    
    public String[] getWeekdays() {
        return weekdays;
    }

    public void setWeekdays(String[] weekdays) {
        this.weekdays = weekdays;
    }

    public ArrayList getSelectedDays() {
        return selectedDays;
    }

    public void setSelectedDays(ArrayList selectedDays) {
        this.selectedDays = selectedDays;
    }

    public Time getMondaytime() {
        return mondaytime;
    }

    public Time getTuesdaytime() {
        return tuesdaytime;
    }

    public Time getWednesdaytime() {
        return wednesdaytime;
    }

    public Time getThursdaytime() {
        return thursdaytime;
    }

    public Time getFridaytime() {
        return fridaytime;
    }

    public Date getEnddate() {
        return enddate;
    }

    public Date getStartdate() {
        return startdate;
    }
}
