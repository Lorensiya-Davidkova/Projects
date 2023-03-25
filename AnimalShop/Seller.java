import java.util.ArrayList;

public class Seller extends User{
    private ArrayList<Product> listOfSellProducts;

    public Seller(String username,String password,String phoneNumber){
        super(username,password,phoneNumber);
        this.listOfSellProducts=new ArrayList<>();
    }
    public ArrayList<Product> getListOfSellProducts(){
        return this.listOfSellProducts;
    }
}
