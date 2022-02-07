



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class Booking {
    private int id;
    private String pickup;
    private String destination;
    private String datetime;
    private int clientid;
    private int driverid;

    public void setDriverid(int driverid) {
        this.driverid = driverid;
    }

    public int getDriverid() {
        return driverid;
    }

    public Booking(int id, String pickup, String destination, String datetime, int clientid, int driverid) {
        this.id = id;
        this.pickup = pickup;
        this.destination = destination;
        this.datetime = datetime;
        this.clientid = clientid;
        this.driverid = driverid;
    }
    
    
    public Booking(int id, String pickup, String destination, String datetime, int clientid){
        this.id = id;
        this.pickup = pickup;
        this.destination = destination;
        this.datetime = datetime;
        this.clientid = clientid;
        
    }
    
    public Booking() {}
    
    public int getid(){
        return id;
    }
    public String getpickup(){
        return pickup;
    }
    public String getdestination(){
        return destination;
    }
    public String getdatetime(){
        return datetime;
    }
    public int getclientid(){
        return clientid;
    }
    
    public void setid(int id){
        this.id = id;
    }
    public void setpickup(String pickup){
        this.pickup = pickup;
    }
    public void setdestination(String destination){
        this.destination = destination;
    }
    public void setdatetime(String datetime){
        this.datetime = datetime;
    }
    public void setclientid(int clientid){
        this.clientid = clientid;
    }
    
    
    
    
            
}
