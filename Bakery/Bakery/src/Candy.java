public class Candy extends Product {
    private String type;
    //String barcode,double price,int quantity,Bakery bakery


    public Candy(String barcode,double price,int quantity,Bakery bakery,String type){
        super(barcode, price, quantity, bakery);
        this.setType(type);
    }
    public void setType(String type){
        this.type=type;
    }
    public String getType(){
        return this.type;
    }

    public void getInformation(){
        System.out.println("From class:"+this.getClass());
        System.out.println("Name of owner: "+this.getBakery().getName()+" Phone number:"+this.getBakery().getPhoneNumber()+" Address:"+this.getBakery().getAddress());
        System.out.println("Barcode: "+this.getBarcode()+"   Price:"+this.getPrice()+"   Quantity:"+this.getQuantity()+"   Type:"+this.getType());
    }

    public double getPromotionalPrice(){
        double toReturn=this.getPrice();
        if(this.getQuantity()>=3 && this.type.equals("Roshen")){
            toReturn=this.getPrice()-0.15*this.getPrice();
        }
        return toReturn;
    }
    public boolean sellProduct(int broi) throws NoEnoughProducts {
        if(this.getQuantity()>=broi){
            this.setQuantity(this.getQuantity()-broi);
        }else{
            throw new NoEnoughProducts();
        }
        return true;
    }
}
