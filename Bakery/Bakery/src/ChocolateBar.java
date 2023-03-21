public class ChocolateBar extends Product{
    private String usedFruits;

    public ChocolateBar(String barcode,double price,int quantity,Bakery bakery,String usedFruits){
        super(barcode, price, quantity, bakery);
        this.setUsedFruits(usedFruits);
    }
    public void setUsedFruits(String usedFruits){
        this.usedFruits=usedFruits;
    }
    public String getUsedFruits(){
        return this.usedFruits;
    }

    @Override
    public void getInformation() {
        System.out.println("From class:"+this.getClass());
        System.out.println("Name of owner: "+this.getBakery().getName()+" " +
                "Phone number:"+this.getBakery().getPhoneNumber()+
                " Address:"+this.getBakery().getAddress());
        System.out.println("Barcode: "+this.getBarcode()+"   Price:"+this.getPrice()+"   Quantity:"+this.getQuantity()+"   UsedFruits:"+this.getUsedFruits());
    }

    @Override
    public double getPromotionalPrice() {
        return this.getPrice()-0.15*this.getPrice();
    }

    @Override
    public boolean sellProduct(int broi) throws NoEnoughProducts {
        if(broi<=this.getQuantity()){
            this.setQuantity(this.getQuantity()-broi);
        }else{
            throw new NoEnoughProducts();
        }
        return true;
    }
}
