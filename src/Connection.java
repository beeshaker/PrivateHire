

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class Connection {
    
    public User login(String username, String pass){
          int id = 0;
            String user = "";
            String password = "";
            String role = "";     
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        } 
        catch (ClassNotFoundException e) {
            System.out.println(e);            
        }
        java.sql.Connection connection = null;
        Statement stmt = null;
        String query = "SELECT * FROM `users` WHERE `pass`= " + " '" + pass +"'"  + " AND `username` = " + "'"+username + "'";
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/privatehire", "root", "");            
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            int count = 0;
            
        while(rs.next()){
            id = rs.getInt("ID");
            user = rs.getString("username");
            password = rs.getString("pass");
            role = rs.getString("role");
            count = count+1;
        }
        
        if (count==1){
            //JOptionPane.showMessageDialog(null,"User, Found Access Granted!");
            if ("driver".equals(role)){
                JOptionPane.showMessageDialog(null,"Driver, Found Access Granted!");
                Driver_home y = new Driver_home(id);
                y.setVisible(true);                
                //return true;
            }
            else if ("client".equals(role)){
                JOptionPane.showMessageDialog(null,"Client, Found Access Granted!");
                Client_home x = new Client_home(id);
                x.setVisible(true);
               // return true;
            }
            else if ("ccenter".equals(role)){
                JOptionPane.showMessageDialog(null,"Client, Found Access Granted!");
                Staff_home x = new Staff_home();
                x.setVisible(true);
               // return true;
            }
            else{
                JOptionPane.showMessageDialog(null,"Unassigned User,Access Denied!");
            }
            
           // return true;
            
        }
        else if (count>1){
            JOptionPane.showMessageDialog(null,"Duplicate User, Access Denied!");
            //return false;
        } 
            else {
            JOptionPane.showMessageDialog(null, "user doesn't exsist. ");
            Login x =new Login();
            x.setVisible(true);
           // return false;
             }
          
            
 
        } catch (SQLException e) {
            System.out.println(e);
           // return false;
            
        } finally {
            try
            {
                if(connection != null)
                    connection.close();
                System.out.println("Connection closed !!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return new User(id, user,role, pass);
        
    }
    public int getmaxclient(){
        int i=0;
        
     try
        {
            Class.forName("com.mysql.jdbc.Driver");
        } 
        catch (ClassNotFoundException e) {
            
            
        }
        
        java.sql.Connection connection = null;
        Statement stmt = null;
        String query = "SELECT MAX(id) FROM users;";
        
        try {
            connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/PrivateHire", "root", "");
            
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            int count = 0;
            
        while(rs.next()){
                        
          
            i = rs.getInt("MAX(id)");
             }
          
            
 
        } catch (SQLException e) {
            System.out.println("Connection failed !!");
            
            
        } finally {
            try
            {
                if(connection != null)
                    connection.close();
                System.out.println("Connection closed !!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return i;
        
    }
    
    public int getmaxid(String var,String table){
        int i=0;
        
     try
        {
            Class.forName("com.mysql.jdbc.Driver");
        } 
        catch (ClassNotFoundException e) {
            
            
        }
        
        java.sql.Connection connection = null;
        Statement stmt = null;
        String query = "SELECT MAX( '"+var+"') FROM "+table+";";
        
        try {
            connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/PrivateHire", "root", "");
            
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            int count = 0;
            
        while(rs.next()){
                        
          
            i = rs.getInt("MAX(id)");
             }
          
            
 
        } catch (SQLException e) {
            System.out.println("Connection failed !!");
            
            
        } finally {
            try
            {
                if(connection != null)
                    connection.close();
                System.out.println("Connection closed !!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return i;
        
    }
    
    public void insert_enquiry(int userid, String title , String enquiry) {
        
     try
        {
            Class.forName("com.mysql.jdbc.Driver");
        } 
        catch (ClassNotFoundException e) {
            
            
        }
     
    int id = getmaxid("id","enquiry") + 1;
    
        
        java.sql.Connection connection = null;
        Statement stmt = null;
        String query = "INSERT INTO `enquiry`(`id`,`userid`,`title`, `enquiry`) VALUES ("+id+","+userid+",'"+title+"','"+enquiry+"')";
        
        try {
            connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/privatehire", "root", "");
            
            stmt = connection.createStatement();
            stmt.executeUpdate(query);        
            JOptionPane.showMessageDialog(null, "Submitted Successfully!");
          
            
 
        } catch (SQLException e) {
            e.printStackTrace();
            
            
        } finally {
            try
            {
                if(connection != null)
                    connection.close();
                System.out.println("Connection closed !!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
}
     
    public void insert_booking(String pickup,String destination, String datetime, int clientid){
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        } 
        catch (ClassNotFoundException e) {
            
            
        }
     
     int bookingid = getmaxid("book_id","booking") + 1;
    
        
        java.sql.Connection connection = null;
        Statement stmt = null;
        String query = "INSERT INTO `booking`(`book_id`,`pickup`,`destination`, `datetime`, `clientid`) VALUES ("+bookingid+",'"+pickup+"','"+destination+"','"+datetime+"', '"+clientid+"')";
        
        try {
            connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/privatehire", "root", "");
            
            stmt = connection.createStatement();
            stmt.executeUpdate(query);        
            JOptionPane.showMessageDialog(null, "Booked Successfully!");
            Login l = new Login();
            l.setVisible(true);
          
            
 
        } catch (SQLException e) {
            e.printStackTrace();
            
            
        } finally {
            try
            {
                if(connection != null)
                    connection.close();
                System.out.println("Connection closed !!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        
    }
    
  public void insert_client(String pass, String username, String name, String phone, String address, String email){
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        } 
        catch (ClassNotFoundException e) {
            
            
        }
     
     int userid = getmaxclient() + 1;
    
        
        java.sql.Connection connection = null;
        Statement stmt = null;
        String query = "INSERT INTO `users`(`ID`, `pass`, `username`, `role) VALUES ("+userid+",'"+pass+"','"+username+"','client);"
                + "INSERT INTO `client`(`userid`, `name`, `phone`, `address`, `email`) VALUES ("+userid+",'"+name+"','"+phone+"','"+address+"', '"+email+"')";
        
        try {
            connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/privatehire", "root", "");
            
            stmt = connection.createStatement();
            stmt.executeUpdate(query);        
            JOptionPane.showMessageDialog(null, "Booked Successfully!");
          
            
 
        } catch (SQLException e) {
            e.printStackTrace();
            
            
        } finally {
            try
            {
                if(connection != null)
                    connection.close();
                System.out.println("Connection closed !!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        
    }
  
  public void insert_driver(String pass, String username, String name, String car, int seats){
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        } 
        catch (ClassNotFoundException e) {
            
            
        }
     
     int userid = getmaxclient() + 1;
    
        
        java.sql.Connection connection = null;
        Statement stmt = null;
         String query = "INSERT INTO `users`(`ID`, `pass`, `username`, `role) VALUES ("+userid+",'"+pass+"','"+username+"',' driver);"
                + "INSERT INTO `drivers`(`driverid`, `name`, `car`, `seats`) VALUES ("+userid+",'"+name+"',"+seats+")";
      
        try {
            connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/privatehire", "root", "");
            
            stmt = connection.createStatement();
            stmt.executeUpdate(query);        
            JOptionPane.showMessageDialog(null, "Booked Successfully!");
          
            
 
        } catch (SQLException e) {
            e.printStackTrace();
            
            
        } finally {
            try
            {
                if(connection != null)
                    connection.close();
                System.out.println("Connection closed !!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        
    }
  public ArrayList<Booking> get_clientbookings(int client){
        
        ArrayList<Booking> avaliablebookings = new ArrayList();
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        } 
        catch (ClassNotFoundException e) {
            
            
        }
        
        java.sql.Connection connection = null;
        Statement stmt = null;
        String query = "SELECT * FROM booking where clientid = " + client +" and driverid is NOT Null";
        
        try {
            connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/PrivateHire", "root", "");
            
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            int count = 0;
            
        while(rs.next()){
            
            Booking avaliable = new Booking(rs.getInt("book_id"),rs.getString("pickup"),rs.getString("destination"),rs.getString("datetime").toString(),rs.getInt("clientid"),rs.getInt("driverid"
                    + ""));
                        
            avaliablebookings.add(avaliable);
          
            
             }
          
           
 
        } catch (SQLException e) {
            System.out.println("Connection failed !!");
            
            
        } finally {
            try
            {
                if(connection != null)
                    connection.close();
                System.out.println("Connection closed !!");
            } catch (SQLException e) {
                e.printStackTrace();
               
            }
        }
        
        return avaliablebookings;
    }
  
  public ArrayList<Inquiry> get_Inquirys(){
        
        ArrayList<Inquiry> inqs = new ArrayList();
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        } 
        catch (ClassNotFoundException e) {
            
            
        }
        
        java.sql.Connection connection = null;
        Statement stmt = null;
        String query = "SELECT * FROM enquiry where reply is Null";
        
        try {
            connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/PrivateHire", "root", "");
            
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            int count = 0;
            
        while(rs.next()){
            
            Inquiry inq = new Inquiry(rs.getInt("id"),rs.getInt("userid"),rs.getString("title"),rs.getString("enquiry"));
                        
            inqs.add(inq);
          
            
             }
          
           
 
        } catch (SQLException e) {
            System.out.println("Connection failed !!");
            
            
        } finally {
            try
            {
                if(connection != null)
                    connection.close();
                System.out.println("Connection closed !!");
            } catch (SQLException e) {
                e.printStackTrace();
               
            }
        }
        
        return inqs;
    }
    
    
   public ArrayList<Booking> get_bookings(){
        
        ArrayList<Booking> avaliablebookings = new ArrayList();
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        } 
        catch (ClassNotFoundException e) {
            
            
        }
        
        java.sql.Connection connection = null;
        Statement stmt = null;
        String query = "SELECT * FROM booking where driverid is NULL;";
        
        try {
            connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/PrivateHire", "root", "");
            
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            int count = 0;
            
        while(rs.next()){
            
            Booking avaliable = new Booking(rs.getInt("book_id"),rs.getString("pickup"),rs.getString("destination"),rs.getString("datetime").toString(),rs.getInt("clientid"));
                        
            avaliablebookings.add(avaliable);
          
            
             }
          
           
 
        } catch (SQLException e) {
            System.out.println("Connection failed !!");
            
            
        } finally {
            try
            {
                if(connection != null)
                    connection.close();
                System.out.println("Connection closed !!");
            } catch (SQLException e) {
                e.printStackTrace();
               
            }
        }
        
        return avaliablebookings;
    }
    
   public ArrayList<Driver> all_driver(){
           ArrayList<Driver> drivers = new ArrayList();
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        } 
        catch (ClassNotFoundException e) {
            System.out.println(e);            
        }
        java.sql.Connection connection = null;
        Statement stmt = null;        
        String query = "SELECT * FROM drivers ;";
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/privatehire", "root", "");            
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
          
            
        while(rs.next()){
            int id = rs.getInt("ID");
            String name = rs.getString("name");
            String role = rs.getString("role");
            String pass = rs.getString("pass");
            int seats = rs.getInt("seats");
            String car = rs.getString("car");
            Driver d = new Driver(id,name,role,pass,seats,car);
            drivers.add(d);
            
        }

        } catch (SQLException e) {
            System.out.println(e);
           // return false;
            
        } finally {
            try
            {
                if(connection != null)
                    connection.close();
                System.out.println("Connection closed !!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
      
          return drivers; 
        
                
        
    }
   public ArrayList<Client> get_clients(){
        
        ArrayList<Client> clients = new ArrayList();
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        } 
        catch (ClassNotFoundException e) {
            
            
        }
        
        java.sql.Connection connection = null;
        Statement stmt = null;
        String query = "SELECT * FROM client where userid in (select clientid from booking)";
        
        try {
            connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/PrivateHire", "root", "");
            
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            int count = 0;
            
        while(rs.next()){
            
            Client client = new Client(rs.getInt("userid"),rs.getString("name"),"","",rs.getString("address"),rs.getString("email"),rs.getString("phone"));
                      
            clients.add(client);
          
            
             }
          
           
 
        } catch (SQLException e) {
            System.out.println("Connection failed !!");
            
            
        } finally {
            try
            {
                if(connection != null)
                    connection.close();
                System.out.println("Connection closed !!");
            } catch (SQLException e) {
                e.printStackTrace();
               
            }
        }
        
        return clients;
    }
    
    public Booking getonebooking(int id){
        
        Booking b = new Booking();
      
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        } 
        catch (ClassNotFoundException e) {
            System.out.println(e);            
        }
        java.sql.Connection connection = null;
        Statement stmt = null;
        String query = "select * from booking where book_id = "+ id;
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/privatehire", "root", "");            
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
          
            
        while(rs.next()){
            
            b.setDriverid(rs.getInt("driverid"));
            b.setclientid(rs.getInt("driverid"));
            b.setpickup(rs.getString("pickup"));
            b.setdestination(rs.getString("destination"));
           
            
            
            
            
        }

        } catch (SQLException e) {
            System.out.println(e);
           // return false;
            
        } finally {
            try
            {
                if(connection != null)
                    connection.close();
                System.out.println("Connection closed !!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        
      
             
return b;
       
        
                
        
    }
    
     
    public Driver booked_driver(int did){
            int id = 0;
            String name = "";
            String phone = "";
            String role = "";
            String pass = "";
            int seats = 0;
            String car = "";
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        } 
        catch (ClassNotFoundException e) {
            System.out.println(e);            
        }
        java.sql.Connection connection = null;
        Statement stmt = null;        
        String query = "SELECT * FROM users INNER JOIN drivers ON users.ID = drivers.driverid WHERE ID = "+did+";";
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/privatehire", "root", "");            
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
          
            
        while(rs.next()){
            id = rs.getInt("ID");
            name = rs.getString("name");
            role = rs.getString("role");
            pass = rs.getString("pass");
            seats = rs.getInt("seats");
            car = rs.getString("car");
            
            
        }

        } catch (SQLException e) {
            System.out.println(e);
           // return false;
            
        } finally {
            try
            {
                if(connection != null)
                    connection.close();
                System.out.println("Connection closed !!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
      
          return new Driver(id,name,role,pass,seats,car);
        
                
        
    }
    
    
    public Booking this_booking(int bid){
            int id = 0;
            String pickup = "";
            String destination = "";
            String departure = "";
            int clientid = 0;
           
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        } 
        catch (ClassNotFoundException e) {
            System.out.println(e);            
        }
        java.sql.Connection connection = null;
        Statement stmt = null;        
        String query = "SELECT * FROM booking WHERE book_id = "+bid+";";
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/privatehire", "root", "");            
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
          
            
        while(rs.next()){
            id = rs.getInt("book_id");
            pickup = rs.getString("pickup");
            destination = rs.getString("destination");
            departure = rs.getString("datetime");
            clientid = rs.getInt("clientid");           
            
            
        }

        } catch (SQLException e) {
            System.out.println(e);
           // return false;
            
        } finally {
            try
            {
                if(connection != null)
                    connection.close();
                System.out.println("Connection closed !!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
      
          return new Booking(id,pickup,destination,departure,clientid);
          
    }
    
    
    
    public ArrayList<TripReview> get_all_reviews(){
        
        ArrayList<TripReview> reviews = new ArrayList();
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        } 
        catch (ClassNotFoundException e) {
            
            
        }
        
        java.sql.Connection connection = null;
        Statement stmt = null;
        String query = "select a.name, b.name as 'drivername', c.review, c.rating from client a inner join booking e on e.clientid = a.userid inner join drivers b on b.driverid = e.driverid inner join reviews c on c.bookingid = e.book_id";
        
        try {
            connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/PrivateHire", "root", "");
            
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            int count = 0;
            
        while(rs.next()){
            
            TripReview re = new TripReview(rs.getString("drivername"),rs.getString("name"),rs.getString("review"),rs.getInt("rating"));
            
                        
            reviews.add(re);
          
            
             }
          
           
 
        } catch (SQLException e) {
            System.out.println("Connection failed !!");
            
            
        } finally {
            try
            {
                if(connection != null)
                    connection.close();
                System.out.println("Connection closed !!");
            } catch (SQLException e) {
                e.printStackTrace();
               
            }
        }
        
        return reviews;
    }
    
   
 
    public String get_enquiry (int eid){
        String enquiry = "";
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        } 
        catch (ClassNotFoundException e) {
            System.out.println(e);            
        }
        java.sql.Connection connection = null;
        Statement stmt = null;        
        String query = "SELECT * FROM enquiry WHERE id = "+eid+";";
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/privatehire", "root", "");            
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
          
            
        while(rs.next()){
            
            enquiry = rs.getString("enquiry");
                    
            
            
        }

        } catch (SQLException e) {
            System.out.println(e);
           // return false;
            
        } finally {
            try
            {
                if(connection != null)
                    connection.close();
                System.out.println("Connection closed !!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
      
          return enquiry;
    }
    
    public void insert_reply(String reply, int eid){
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        } 
        catch (ClassNotFoundException e) {
            
            
        }
     
         
        
        java.sql.Connection connection = null;
        Statement stmt = null;
        String query = "UPDATE enquiry SET reply = '"+reply+"' WHERE id = "+eid+"" ;
        try {
            connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/privatehire", "root", "");
            
            stmt = connection.createStatement();
            stmt.executeUpdate(query);        
            JOptionPane.showMessageDialog(null, "Reply updated successfully!");
          
            
 
        } catch (SQLException e) {
            e.printStackTrace();
            
            
        } finally {
            try
            {
                if(connection != null)
                    connection.close();
                System.out.println("Connection closed !!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
   
    
    public void insert_review(int rating, int bid, String review){
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        } 
        catch (ClassNotFoundException e) {
            
            
        }
     
         
        
        java.sql.Connection connection = null;
        Statement stmt = null;
        String query = "INSERT INTO `reviews`(`bookingid`, `rating`, `review`) VALUES ("+bid+","+rating+", '"+review+"')";
        try {
            connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/privatehire", "root", "");
            
            stmt = connection.createStatement();
            stmt.executeUpdate(query);        
            JOptionPane.showMessageDialog(null, "Review updated successfully!");
          
            
 
        } catch (SQLException e) {
            e.printStackTrace();
            
            
        } finally {
            try
            {
                if(connection != null)
                    connection.close();
                System.out.println("Connection closed !!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void updateBooking(int driver, int booking){
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        } 
        catch (ClassNotFoundException e) {
            
            
        }
     
         
        
        java.sql.Connection connection = null;
        Statement stmt = null;
        String query = "UPDATE booking SET driverid = "+driver+" WHERE book_id = "+booking+"" ;
        try {
            connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/privatehire", "root", "");
            
            stmt = connection.createStatement();
            stmt.executeUpdate(query);        
            JOptionPane.showMessageDialog(null, "Review updated successfully!");
          
            
 
        } catch (SQLException e) {
            e.printStackTrace();
            
            
        } finally {
            try
            {
                if(connection != null)
                    connection.close();
                System.out.println("Connection closed !!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void updateEnquiry(int id, String reply){
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        } 
        catch (ClassNotFoundException e) {
            
            
        }
     
         
        
        java.sql.Connection connection = null;
        Statement stmt = null;
        String query = "UPDATE enquiry SET reply = '"+reply+"' WHERE book_id = "+id+"" ;
        try {
            connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/privatehire", "root", "");
            
            stmt = connection.createStatement();
            stmt.executeUpdate(query);        
            JOptionPane.showMessageDialog(null, "Review updated successfully!");
          
            
 
        } catch (SQLException e) {
            e.printStackTrace();
            
            
        } finally {
            try
            {
                if(connection != null)
                    connection.close();
                System.out.println("Connection closed !!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    public ArrayList mytrips(int cid){
        ArrayList<String> trips = new ArrayList<String>();
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        } 
        catch (ClassNotFoundException e) {
            System.out.println(e);            
        }
        java.sql.Connection connection = null;
        Statement stmt = null;        
        String query = "SELECT * FROM booking WHERE clientid = "+cid+";";
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/privatehire", "root", "");            
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
          
            
        while(rs.next()){
            
           
                    
            trips.add(rs.getString("book_id"));
            
        }

        } catch (SQLException e) {
            System.out.println(e);
           // return false;
            
        } finally {
            try
            {
                if(connection != null)
                    connection.close();
                System.out.println("Connection closed !!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return trips;
    }
    
}
  