package DB;

import java.sql.*;
import java.util.ArrayList;
import javax.annotation.Resource;
import javax.faces.context.FacesContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import logikk.Dish;
import logikk.Order;
import logikk.Status;
import logikk.User;

public class Database {

    @Resource(name = "jdbc/hc_realm")
    private DataSource ds;
    private Connection connection;
    private String currentUser = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();

    public Database() {
        try {
            Context con = new InitialContext();
            ds = (DataSource) con.lookup("jdbc/hc_realm");
        } catch (NamingException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Order> getPendingOrders(String query) {
        ArrayList<Order> orders = new ArrayList();
        ResultSet res = null;
        Statement stm = null;
        openConnection();
        try {
            stm = connection.createStatement();
            res = stm.executeQuery(query);
            while (res.next()) {
                java.sql.Date date = res.getDate("dates");
                java.sql.Time timeOfDelivery = res.getTime("TIMEOFDELIVERY");
                String deliveryAddress = res.getString("DELIVERYADDRESS");
                int status = res.getInt("STATUS");
                int orderId = res.getInt("ORDERID");
                Order orderToBeAdded = new Order(date,timeOfDelivery, deliveryAddress, status);
                orderToBeAdded.setOrderId(orderId);
                orders.add(orderToBeAdded);
            }
        } catch (SQLException e) {
        } finally {
            Cleaner.closeConnection(connection);
            Cleaner.closeResSet(res);
            Cleaner.closeSentence(stm);
        }
        return orders;
    }

    //FOR ADMIN
    public void updateOrder(Order s) {
        PreparedStatement sqlRead = null;
        ResultSet res = null;
        openConnection();
        try {
            sqlRead = connection.prepareStatement("UPDATE ASD.ORDERS set STATUS=? where ORDERID=?");
            sqlRead.setInt(1, s.getStatusNumeric());
            sqlRead.setInt(2, s.getOrderId());
            sqlRead.executeUpdate();
        } catch (Exception e) {
            Cleaner.closeConnection(connection);
            Cleaner.closeResSet(res);
            Cleaner.closeSentence(sqlRead);
        }
    }

    public ArrayList<Order> getOrderOverview() {
        ArrayList<Order> orders = new ArrayList();
        PreparedStatement sqlRead = null;
        ResultSet res = null;
        openConnection();

        try {
            sqlRead = connection.prepareStatement("SELECT * FROM ASD.ORDERS");
            res = sqlRead.executeQuery();
            while (res.next()) {
                java.sql.Date date = res.getDate("dates");
                String deliveryAddress = res.getString("DELIVERYADDRESS");
                java.sql.Time timeOfDelivery = res.getTime("TIMEOFDELIVERY");
                int status = res.getInt("STATUS");
                Order orderToBeAdded = new Order(date,timeOfDelivery, deliveryAddress, status);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Cleaner.closeConnection(connection);
            Cleaner.closeResSet(res);
            Cleaner.closeSentence(sqlRead);
        }
        return orders;
    }

    //FOR DRIVER
    public ArrayList<Order> getDriversList() {
        ArrayList<Order> orders = new ArrayList();
        PreparedStatement sqlRead = null;
        ResultSet res = null;
        openConnection();
        try {
            sqlRead = connection.prepareStatement("SELECT * FROM ORDERS WHERE STATUS = ?");
            sqlRead.setInt(1, Status.ON_THE_ROAD.getCode());
            res = sqlRead.executeQuery();
            while (res.next()) {
                java.sql.Date date = res.getDate("dates");
                String deliveryAddress = res.getString("DELIVERYADDRESS");
                java.sql.Time timeOfDelivery = res.getTime("TIMEOFDELIVERY");
                int status = res.getInt("STATUS");
                orders.add(new Order(date,timeOfDelivery, deliveryAddress, status));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Cleaner.closeConnection(connection);
            Cleaner.closeResSet(res);
            Cleaner.closeSentence(sqlRead);
        }
        return orders;

    }

    public boolean changePassword(User user) {
        PreparedStatement sqlLogIn = null;
        openConnection();
        boolean ok = false;
        try {
            sqlLogIn = connection.prepareStatement("UPDATE BRUKER SET PASSORD = ? WHERE BRUKERNAVN = ?");
            sqlLogIn.setString(1, user.getPassword());
            sqlLogIn.setString(2, user.getUsername());
            sqlLogIn.executeUpdate();
            connection.commit();
            ok = true;


        } catch (SQLException e) {
            System.out.println(e.getMessage());
            Cleaner.rollback(connection);

        } finally {
            Cleaner.setAutoCommit(connection);
            Cleaner.closeSentence(sqlLogIn);
        }
        closeConnection();
        return ok;
    }

    public boolean newUser(User user) {
        PreparedStatement sqlRegNewuser = null;
        PreparedStatement sqlRegNewRole = null;
        openConnection();
        boolean ok = false;
        try {
            sqlRegNewuser = connection.prepareStatement("INSERT INTO users VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
            sqlRegNewuser.setString(1, user.getUsername());
            sqlRegNewuser.setString(2, user.getPassword());
            sqlRegNewuser.setString(3, user.getFirstName());
            sqlRegNewuser.setString(4, user.getSurname());
            sqlRegNewuser.setString(5, user.getAddress());
            sqlRegNewuser.setString(6, user.getPhone());
            sqlRegNewuser.setString(7, user.getEmail());
            sqlRegNewuser.setInt(8, user.getPostnumber());
            sqlRegNewuser.executeUpdate();

            sqlRegNewRole = connection.prepareStatement("INSERT INTO roles VALUES(?,?)");
            sqlRegNewRole.setString(1, "customer");
            sqlRegNewRole.setString(2, user.getUsername());
            sqlRegNewRole.executeUpdate();
            connection.commit();
            ok = true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            Cleaner.rollback(connection);

        } finally {
            Cleaner.setAutoCommit(connection);
            Cleaner.closeSentence(sqlRegNewuser);
        }
        closeConnection();
        return ok;
    }
//FOR MENU

    public ArrayList<Dish> getDishes() {
        PreparedStatement sentence = null;
        openConnection();
        ArrayList<Dish> dishes = new ArrayList<Dish>();
        try {
            sentence = connection.prepareStatement("select * from DISH");
            ResultSet res = sentence.executeQuery();
            connection.commit();
            while (res.next()) {
                int dishid = res.getInt("DISHID");
                String dishname = res.getString("DISHNAME");
                double dishprice = res.getDouble("DISHPRICE");
                Dish newdish = new Dish(dishid, dishname, dishprice, 1);
                dishes.add(newdish);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            Cleaner.rollback(connection);

        } finally {
            Cleaner.setAutoCommit(connection);
            Cleaner.closeSentence(sentence);
        }
        closeConnection();
        return dishes;
    }

    public boolean order(Order order) {
        PreparedStatement statement = null;
        PreparedStatement statement2 = null;
        openConnection();
        boolean result = false;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement("insert into orders(timeofdelivery,"
                    + " deliveryaddress, status, postalcode,dates) values(?, ?, ?, ?, ?,?)");
            statement.setTime(1, order.getTimeOfDelivery());
            statement.setString(2, order.getDeliveryAddress());
            statement.setInt(3, 7);
            statement.setInt(4, order.getPostalcode()); 
            statement.setDate(5, new java.sql.Date(order.getDate().getTime()));
            statement.executeQuery();
            ResultSet keys = statement.getGeneratedKeys();
            int key = keys.getInt(1);
            System.out.println("Key: " + key);

            for (int i = 0; i < order.getOrderedDish().size(); i++) {
                statement2 = connection.prepareStatement("insert into dishes_ordered(dishid, orderid, dishcount) values(?, ?, ?)");
                statement2.setInt(1, getDishId(order.getOrderedDish().get(i).getDishName()));
                statement2.setInt(2, key);
                statement2.setInt(3, order.getOrderedDish().get(i).getCount());
                System.out.println(order.getOrderedDish().get(i).getCount());
            }
            connection.commit();
            result = true;
        } catch (SQLException e) {
            System.out.println(e);
            Cleaner.rollback(connection);
            result = false;
        } finally {
            Cleaner.setAutoCommit(connection);
            Cleaner.closeSentence(statement);
        }
        closeConnection();
        return result;
    }

    public int getDishId(String dishname) {
        PreparedStatement statement = null;
        int result = 0;
        try {
            statement = connection.prepareStatement("SELECT dishid FROM dish WHERE dishname = ?");
            statement.setString(1, dishname);
            ResultSet res = statement.executeQuery();
            if (res.next()) {
                result = res.getInt(dishname);
            } else {
                result = -1;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            Cleaner.rollback(connection);

        }
        return result;
    }

    public boolean userExist(String username) {
        PreparedStatement sqlLogIn = null;
        openConnection();
        boolean exist = false;
        try {
            sqlLogIn = connection.prepareStatement("SELECT * FROM users WHERE username = '" + username + "'");
            ResultSet res = sqlLogIn.executeQuery();
            connection.commit();
            if (res.next()) {
                exist = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            Cleaner.rollback(connection);

        } finally {
            Cleaner.setAutoCommit(connection);
            Cleaner.closeSentence(sqlLogIn);
        }
        closeConnection();
        return exist;
    }

    public User getUser() {
        PreparedStatement statement = null;
        openConnection();
        User newUser = new User();
        try {
            statement = connection.prepareStatement("SELECT * FROM users WHERE username = '" + currentUser + "'");
            ResultSet res = statement.executeQuery();
            connection.commit();
            while (res.next()) {
                String username = res.getString("username");
                String password = res.getString("password");
                String firstname = res.getString("firstname");
                String surname = res.getString("surname");
                String address = res.getString("address");
                String mobilenr = res.getString("mobilenr");
                int postalcode = res.getInt("postalcode");
                String email = res.getString("email");
                newUser = new User(username, password, firstname, surname, address, mobilenr, postalcode);
                newUser.setEmail(email);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            Cleaner.rollback(connection);

        } finally {
            Cleaner.setAutoCommit(connection);
            Cleaner.closeSentence(statement);
        }
        try {
            statement = connection.prepareStatement("SELECT * FROM POSTAL_NO WHERE zip=?");
            statement.setInt(1, newUser.getPostnumber());
            ResultSet res = statement.executeQuery();
            connection.commit();
            while(res.next()) {
                String postalArea = res.getString("place");
                newUser.setCity(postalArea);
                System.out.println(postalArea);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            Cleaner.rollback(connection);

        } finally {
            Cleaner.setAutoCommit(connection);
            Cleaner.closeSentence(statement);
        }
        closeConnection();
        return newUser;
    }

    private void openConnection() {
        try {
            if (ds == null) {
                throw new SQLException("No connection");
            }
            connection = ds.getConnection();
            System.out.println("Databaseconnection established");
        } catch (SQLException e) {
            Cleaner.writeMessage(e, "Construktor");
        }
    }

    private void closeConnection() {
        System.out.println("Closing databaseconnection");
        Cleaner.closeConnection(connection);
    }

    public boolean changeData(User user) {
        PreparedStatement sqlUpdProfile = null;
        boolean ok = false;
        openConnection();
        try {
            sqlUpdProfile = connection.prepareStatement("update users set firstname = ?,surname = ?, address = ?, mobilenr = ?, postalcode = ?, password = ? where username = ?");
            sqlUpdProfile.setString(1, user.getFirstName());
            sqlUpdProfile.setString(2, user.getSurname());
            sqlUpdProfile.setString(3, user.getAddress());
            sqlUpdProfile.setString(4, user.getPhone());
            sqlUpdProfile.setInt(5, user.getPostnumber());
            sqlUpdProfile.setString(6, user.getPassword());
            sqlUpdProfile.setString(7, currentUser);
            ok = true;
            sqlUpdProfile.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            Cleaner.writeMessage(e, "changeData()");
        } finally {
            Cleaner.closeSentence(sqlUpdProfile);
        }
        closeConnection();
        return ok;
    }
    public boolean regDish(Dish dish){
        PreparedStatement sqlRegNew = null;
        openConnection();
        boolean ok = false;
        try {
            sqlRegNew = connection.prepareStatement("insert into dish(dishid,dishname,dishprice) values(?, ?, ?)");
            sqlRegNew.setInt(1, dish.getDishId());
            sqlRegNew.setString(2, dish.getDishName());
            sqlRegNew.setDouble(3, dish.getPrice());
            sqlRegNew.executeUpdate();

            connection.commit();

            /*
             * Transaksjon slutt
             */
            ok = true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            Cleaner.rollback(connection);

        } finally {
            Cleaner.setAutoCommit(connection);
            Cleaner.closeSentence(sqlRegNew);
        }
        closeConnection();
        return ok;
    }
    public boolean deleteDish(Dish dish) {
        boolean ok = false;
        PreparedStatement sqlDel = null;
        openConnection();
        try {
            sqlDel = connection.prepareStatement("DELETE FROM DISH WHERE dishid = ?");
            sqlDel.setInt(1, dish.getDishId());
            sqlDel.executeUpdate();
            connection.commit();
            ok = true;

        } catch (SQLException e) {
            Cleaner.writeMessage(e, "deleteWorkout()");
        } finally {
            Cleaner.closeSentence(sqlDel);
        }
        closeConnection();
        return ok;



    }
    
     public boolean changeDishData(Dish dish) {
        PreparedStatement sqlUpdDish = null;
        boolean ok = false;
        openConnection();
        try {
            //String sql = "update eksemplar set laant_av = '" + navn + "' where isbn = '" + isbn + "' and eks_nr = " + eksNr;
            sqlUpdDish = connection.prepareStatement("update dish set dishname = ?,dishprice = ? where dishid = ?");
            sqlUpdDish.setString(1, dish.getDishName());
            sqlUpdDish.setDouble(2, dish.getPrice());
            sqlUpdDish.setInt(3, dish.getDishId());
          
            ok = true;
            sqlUpdDish.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            Cleaner.writeMessage(e, "changeData()");
        } finally {
            Cleaner.closeSentence(sqlUpdDish);
        }
        closeConnection();
        return ok;
    }
     
      public ArrayList<Dish> getAdminDishes() {
        PreparedStatement sentence = null;
        openConnection();
        ArrayList<Dish> dishes = new ArrayList<Dish>();
        try {
            sentence = connection.prepareStatement("select * from DISH");
            ResultSet res = sentence.executeQuery();
            connection.commit();
            while (res.next()) {
                int dishid = res.getInt("DISHID");
                String dishname = res.getString("DISHNAME");
                double dishprice = res.getDouble("DISHPRICE");
                Dish newdish = new Dish(dishname, dishprice);
                newdish.setDishId(dishid);
                dishes.add(newdish);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            Cleaner.rollback(connection);

        } finally {
            Cleaner.setAutoCommit(connection);
            Cleaner.closeSentence(sentence);
        }
        closeConnection();
        return dishes;
    }
}
