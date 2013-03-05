package DB;

import beans.*;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Jørn
 */
class DBHandler{
  private static Connection db = null;
  private String databasedriver = "org.apache.derby.jdbc.ClientDriver";
  private String dburl;
  
  
  public DBHandler(String db, String user, String pass){
    if(db != null || user != null || pass != null){
      try{
        Class.forName(databasedriver); // laster inn driverklassa
      }
      catch(ClassNotFoundException cnf){
        System.err.println("Driverfeil: Kunne ikkje laste driver! \n "+ cnf.toString());
        System.exit(0); //Ikkje vits å fortsette om databasen ikkje kan koblast opp...
      }
      
      dburl = "jdbc:derby://localhost:1527/"+db+";user="+user+";password="+pass+";";
      try{
        this.db = DriverManager.getConnection(dburl);
      }
      catch(SQLException se){
        System.err.println("Kunne ikkje kople til databasen "+db+" med bruker "+user+".\n" + se);
        System.exit(0);
      }
    }
    else{
      System.err.println(user+":"+pass+"@"+db);
      throw new IllegalArgumentException("Du har ikkje oppgitt bruker, passord eller database.");
    }
  }
  
  private void lukkForbindelse(){
    try{
      db.close();
    }
    catch(SQLException se){
      System.err.println("DB-feil: Feil ved lukking av databaseforbindelse:\n" + se);
      System.exit(0);
    }
  }
  
  private void openDB(){
     try{
      db = DriverManager.getConnection(dburl);   
     }
    catch(SQLException se) {
        System.err.println("Connection ERROR!!!! l.54\n"+se);
        System.exit(0);
    }
  }
  
  private void lukkRS(ResultSet res) {
    try {
      if (res != null) {
        res.close();
      }
    } catch (SQLException se) {
      System.err.println("DB-feil: Feil ved lukking av ResultSet\n" + se);
      System.exit(0);
    }
    finally{
        lukkForbindelse();
    }
  }
  
  private ResultSet nyRES(Statement stm, String query){
      ResultSet res = null;
      try{
        res = stm.executeQuery(query);    
      }
      catch(SQLException sqle){
          System.err.println("Kunne ikkje lage nytt ResultSet\n"+sqle);
          System.exit(0);
      }
      return res;
  }
  
  

  private  Statement nySTM(){
      openDB();
  Statement stm = null;
    try{
      stm = db.createStatement();
    }
    catch(SQLException se){
      System.err.println("DB-feil: Feil ved åpning av statement.\n"+ se);
      System.exit(0);
    }
    return stm;
  }
  
  public void lukkSTM(Statement stm) {
    try{
      if (stm != null) {
        stm.close();
      }
    }
    catch (SQLException se) {
      System.err.println("DB-feil: Feil ved lukking av Statement\n" + se);
      System.exit(0);
    }
  }
  
  private void lukkRSF(ResultSet res, Statement stm){
      lukkRS(res);
      lukkSTM(stm);
      lukkForbindelse();
  }
 
 public boolean sendInsert(String query, Statement stm){
     System.out.println("Sender SQL-query: "+query);
     openDB();
     
     
    try{
        stm.execute(query);
    }
    catch(SQLException sqle){
        System.err.println("Kunne ikkje utføre query:\n"+query+"\n"+sqle);
        return false;
    }
    finally{
        lukkSTM(stm);
        lukkForbindelse();
    }
    return true;
 }
}
 
//HENT FRA DATABASE
 
    