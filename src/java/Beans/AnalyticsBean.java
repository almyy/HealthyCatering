package Beans;
import logikk.Order;
import DB.Database;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.LineChartSeries;

@SessionScoped
@Named("Analytics")
class AnalyticsBean implements Serializable {
    
    private Database db = new Database();
    private Date toDate = new Date();
    private Date fromDate = new Date(toDate.getYear()-1,toDate.getMonth(),toDate.getDay());
    private CartesianChartModel linearModel;
    private float turnoverNow =0; 
    private float turnoverLastYear = 0; 

    public AnalyticsBean() {
        calculateTurnover();
        createLinearModel();
    }
    public void calculateTurnover(){
        java.sql.Date fromDateSql = new java.sql.Date(fromDate.getTime());
        java.sql.Date toDateSql = new java.sql.Date(toDate.getTime());
        String query = "SELECT * FROM orders WHERE dates <='"+toDateSql.toString()+"' and dates>='"+fromDateSql.toString()+"'";
        turnoverNow = db.getTurnoverstatistics(query);
    }
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

    public CartesianChartModel getLinearModel() {
        return linearModel;
    }

    public void createLinearModel() {
        linearModel = new CartesianChartModel();
        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Series 1");

        series1.set(1, 2);
        series1.set(2, 1);
        series1.set(3, 3);
        series1.set(4, 6);
        series1.set(5, 8);

        LineChartSeries series2 = new LineChartSeries();
        series2.setLabel("Series 2");
        series2.setMarkerStyle("diamond");

        series2.set(1, 6);
        series2.set(2, 3);
        series2.set(3, 2);
        series2.set(4, 7);
        series2.set(5, 9);
        linearModel.addSeries(series1);
        linearModel.addSeries(series2);
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