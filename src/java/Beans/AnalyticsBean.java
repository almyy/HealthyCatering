package Beans;

import DB.Database;
import java.io.Serializable;
import java.util.Date;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SessionScoped
@Named("Analytics")
class AnalyticsBean implements Serializable {
    private Database db = new Database();
    private Date fromDate = new Date();
    private Date toDate = new Date();

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }
    
    public String getRevenue() {
        return null;
    }
}