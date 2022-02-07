/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class Client extends User{

   private String address = "";
   private String phone = "";
   private String email = "";
   
   
  
    
    public Client(int id, String name, String role, String pass, String address, String email, String phone) {
        super(id, name, role, pass);
        
        this.email = email;
        this.address = address;
        this.phone = phone;
        
    }
    
    

   
   public String getemail(){
       return email;
   }
 
   public String getaddress(){
       return address;
   }
   public String getphone(){
       return phone;
   }
   
   public void setemail(String email){
       this.email = email;
   }
   public void setaddress(String address){
       this.address = address;
   }
   public void setphone(String phone){
       this.phone = phone;
   }
   
}
