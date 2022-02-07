

/**
 *
 * @author HP
 */
public class Driver extends User{
    
    /*public Client(int id, String name, String role, String pass, String address, String email, String phone) {
        super(id, name, role, pass);
        
        this.email = email;
        this.address = address;
        this.phone = phone;
        
    }*/
    
    public Driver(int id, String name, String role, String pass, int seats,  String car) {
        super(id, name, role, pass);
        
        
        this.seats = seats;
        this.car = car;
    }
    
    private int seats;
    private String car;
    
    
    public String getplate(String plate){
        return plate;
    }
    public int getseats(int seats){
        return seats;
    }
    
    public void setplate(String car){
        this.car = car;
    }
    public void setseat(int seats){
        this.seats = seats;
    }
    
    
}
