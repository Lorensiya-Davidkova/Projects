public class Product {
    private String name;
    private String IDnumber;
    private double price;

    public Product(String name,String IDnumber,double price){
        this.setName(name);
        this.setIDnumber(IDnumber);
        this.setPrice(price);
    }

    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }
    public void setIDnumber(String IDnumber){
        this.IDnumber=IDnumber;
    }
    public String getIDnumber(){
        return this.IDnumber;
    }
    public void setPrice(double price){
        this.price=price;
    }
    public double getPrice(){
        return this.price;
    }
}
