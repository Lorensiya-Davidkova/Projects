import java.io.Serializable;

public abstract class Product implements Serializable {
    private String barcode;
    private double price;
    private int quantity;
    private Bakery bakery;

    public Product(String barcode,double price,int quantity,Bakery bakery){
        this.setBarcode(barcode);
        this.setPrice(price);
        this.setQuantity(quantity);
        this.setBakery(bakery);
    }
    public void setBarcode(String barcode){
        this.barcode=barcode;
    }
    public String getBarcode(){
        return this.barcode;
    }
    public void setPrice(double price){
        this.price=price;
    }
    public double getPrice(){
        return this.price;
    }

    public void setQuantity(int quantity){
        this.quantity=quantity;
    }
    public int getQuantity(){
        return this.quantity;
    }
    public void setBakery(Bakery bakery) {
        this.bakery=bakery;
    }
    public Bakery getBakery(){
        return this.bakery;
    }

    public abstract void getInformation();
    public abstract double getPromotionalPrice();
    public abstract boolean sellProduct(int broi) throws NoEnoughProducts;
}

