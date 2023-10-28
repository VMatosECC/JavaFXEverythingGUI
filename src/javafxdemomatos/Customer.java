
package javafxdemomatos;

public class Customer 
{
    private int    id;
    private String name;
    private String phone;

    public int getId() {return id;}
    public String getName() {return name;}
    public String getPhone() {return phone;}

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
            
    
    public Customer(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return " Customer [ID:" + String.valueOf(id) + ", Name:" + name +
                ", Phone:" + phone + "]";
    }

 
    
    
    
}
