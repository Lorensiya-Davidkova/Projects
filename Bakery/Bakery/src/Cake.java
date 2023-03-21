public class Cake extends Product{
    private double grams;
    private boolean usedDarkChocolate;

    public Cake(String barcode,double price,int quantity,Bakery bakery,double grams,boolean usedDarkChocolate){
        super(barcode, price, quantity, bakery);
        this.setGrams(grams);
        this.setUsedDarkChocolate(usedDarkChocolate);
    }
    public void setGrams(double grams){
        this.grams=grams;
    }
    public double getGrams(){
        return this.grams;
    }
    public void setUsedDarkChocolate(boolean usedDarkChocolate){
        this.usedDarkChocolate=usedDarkChocolate;
    }
    public boolean getUsedDarkChocolate(){
        return this.usedDarkChocolate;
    }

    @Override
    public void getInformation() {
        System.out.println(this.getClass());
        System.out.println("Name of owner: "+this.getBakery().getName()+" Phone number:"+this.getBakery().getPhoneNumber()+" Address:"+this.getBakery().getAddress()+
        "Barcode:"+this.getBarcode()+"   Price:"+this.getPrice()+"   Quantity:"+this.getQuantity()+ "   Grams:"+this.getGrams()+"   UsedDarkChocolate:"+this.getUsedDarkChocolate());
    }

    @Override
    public double getPromotionalPrice() {
        double toReturn=this.getPrice();
        if(this.getQuantity()>=3){
           toReturn=this.getPrice()-0.15*this.getPrice();
        }
        return toReturn;
    }

    @Override
    public boolean sellProduct(int broi) throws NoEnoughProducts {
        if(this.getQuantity()>=broi){
            int newQ=this.getQuantity()-broi;
            this.setQuantity(newQ);
        }else{
            throw new NoEnoughProducts();
        }
        return true;
    }
}
