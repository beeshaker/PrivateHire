/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class User {
    int id;
    private String name;
    private String role;
    private String pass;
    
    public User(int id, String name, String role, String pass){
        this.id = id;
        this.name = name;
        this.role = role;
        this.pass = pass;
    }
    
    
    
    public int getid(){
        return id;
    }
    
    public String getname(){
        return name;
    }
    
    public String getrole(){
        return role;
    }
    
    public String getpass(){
        return pass;
    }
    
    public void setid(int id){
        this.id = id;
    }
    public void setname(String name){
        this.name = name;
    }
    public void setrole(String role){
        this.role = role;
    }
    public void setpass(String pass){
        this.pass = pass;
    }
    
}
