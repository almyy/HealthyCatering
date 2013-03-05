package DB;

import javax.annotation.Resource;
import javax.sql.*;
import java.sql.*;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
/**
 *
 * @author espen
 */
@RequestScoped

public class DSConnect {
    @Resource(name="jdbc/hc_realm") DataSource ds;     
    private Connection c;
    
    public DSConnect(){
        try{
            Context ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("java:comp/env/jdbc/tillerlopet");
        }catch(NamingException ne){
            System.out.println("Data lookup fail.\n"+ne);
        }
        
        
    }
    
    
    private void start(){
        try{
            if(ds == null){
                System.err.println("No connection, ds==null. Aborting.");
                System.exit(0);
            }
            c = ds.getConnection();
        }
        catch(SQLException se){
            System.err.println("Feil ved oppkobling til database, Avslutter.\n"+se);
            System.exit(0);
        }
    }
    private void end(){
        try{
            if(!c.isClosed()) c.close();
        }
        catch(SQLException se){
            System.err.println("Kunne ikkje lukke ds\n"+se);
        }
    }
}   
   