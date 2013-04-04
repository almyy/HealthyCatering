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
    private ArrayList<Order> orders = new ArrayList();
    private float turnoverNow = 0;
    private float turnoverLastYear = 0; 

    public AnalyticsBean() {
        createLinearModel();
    }
    public ArrayList<Order> calculateTurnover(Date fromDate, Date toDate){
        java.sql.Date fromDateSql = new java.sql.Date(fromDate.getTime());
        java.sql.Date toDateSql = new java.sql.Date(toDate.getTime());
        String query = "SELECT * FROM orders WHERE dates <='"+toDateSql.toString()+"' and dates>='"+fromDateSql.toString()+"'";
        orders = db.getTurnoverstatistics(query);
        return orders;
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

    public float getTurnoverLastYear() {
        return turnoverLastYear;
    }

    public float getTurnoverNow() {
        return turnoverNow;
    }
    
    public CartesianChartModel getLinearModel() {
        return linearModel;
    }

    public void createLinearModel() {
        String[] months = {"January","February","March","April","Mai","June","July","August","September",
            "October","November","Descember"};
        ArrayList<Order> orders = calculateTurnover(this.fromDate,this.toDate); 
        linearModel = new CartesianChartModel();
        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Turnover past year");
        float turnOver = 0; 
        for(int i = 0; i < 12; i++){
            for(int u=0; u< orders.size(); u++){
                if(orders.get(u).getDate().getMonth()==i){
                    turnOver+=orders.get(u).getTotalPrice();
                }
            }
            series1.set(months[i], turnOver);
            turnoverNow+=turnOver; 
            turnOver=0;
        }

        LineChartSeries series2 = new LineChartSeries();
        series2.setLabel("Turnover last Year");
        orders = calculateTurnover(new Date(this.fromDate.getYear()-1),this.fromDate);
        
        for(int i = 0; i < 12; i++){
            for(int u=0; u< orders.size(); u++){
                if(orders.get(u).getDate().getMonth()==i){
                    turnOver+=orders.get(u).getTotalPrice();
                }
            }
            series2.set(months[i], turnOver);
            turnoverLastYear+=turnOver; 
            turnOver=0;
        }
        
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