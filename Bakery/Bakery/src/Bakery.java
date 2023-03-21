import java.io.Serial;
import java.io.Serializable;

public class Bakery implements Serializable {
    private String name;
    private String address;

    private String PhoneNumber;
    public Bakery(String name,String address,String PhoneNumber){
        this.setName(name);
        this.setAddress(address);
        this.setPhoneNumber(PhoneNumber);
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }
    public void setAddress(String address){
        this.address=address;
    }
    public String getAddress(){
        return this.address;
    }
    public void setPhoneNumber(String phoneNumber){
        this.PhoneNumber=phoneNumber;
    }
    public String getPhoneNumber(){
        return this.PhoneNumber;
    }
}
