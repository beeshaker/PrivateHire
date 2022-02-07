/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class Trip {
    private int id = 0;
    private String pickup = "";
    private String destination = "";
    private String datetime = "";
    private int clientid = 0;
    private int driverid = 0;
    private String tripduration = "";
    private static int rate = 500;
    private String review = "";
    
    
    public Trip(int id, String pickup, String destination, String datetime, int clientid, int driverid, String tripduration, String review){
        this.id = id;
        this.pickup = pickup;
        this.destination = destination;
        this.datetime = datetime;
        this.clientid = clientid;
        this.driverid = driverid;
        this.tripduration = tripduration;
        this.rate = rate;
        this.review = review;
        
        
    }
    
    public Trip(){
        
    }
    
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
    public int getdriverid(){
        return driverid;
    }
    public String gettripduration(){
        return tripduration;
    }
    public int getrate(){
        return rate;
    }
    public String getreview(){
        return review;
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
    public void setdriverid(int driverid){
        this.driverid = driverid;
    }
    public void settripduration(String driverid){
        this.tripduration = tripduration;
    }
    public void setrate(int rate){
        this.rate = rate;
    }
    public void setreview(String review){
        this.review = review;
    }
}
