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
    
    /*public String getTurnover() {
     * double revenue = db.getTurnover(fromDate, toDate);
     * return String.format("%1$,.2f", revenue);
     * }*/
    
    /*    public String getTurnoverLastYear() {
     * Date lastYearFrom = new Date();
     * Date lastYearTo = new Date();
     * lastYearFrom.setYear(fromDate.getYear()-1);
     * lastYearFrom.setYear(toDate.getYear()-1);
     * double turnover = db.getTurnover(lastYearFrom, lastYearTo);
     * return String.format("%1$,.2f", turnover);
     * }*/
}