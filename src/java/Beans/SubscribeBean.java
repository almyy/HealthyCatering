package Beans;

import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value = "subBean")
@SessionScoped
public class SubscribeBean implements Serializable{

    private ArrayList selectedDays = new ArrayList();
    private String[] weekdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
    private Time mondaytime = new Time(1);
    private Time tuesdaytime = new Time(1);
    private Time wednesdaytime = new Time(1);
    private Time thursdaytime = new Time(1);
    private Time fridaytime = new Time(1);

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
}
