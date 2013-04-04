package logikk;

import java.sql.Time;
import java.util.Date;

public class SubscriptionPlan {
    public Date startdate;
    public Date enddate;
    public Time timeofdelivery;
    public String weekday;
    public String companyusername;
    
    public SubscriptionPlan(Date startdate, Date enddate, Time timeofdelivery, String weekday, String companyusername){
        this.startdate = startdate;
        this.enddate = enddate;
        this.timeofdelivery = timeofdelivery;
        this.weekday = weekday;
        this.companyusername = companyusername;
    }
    
    
}
