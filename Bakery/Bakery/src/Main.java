import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    static ArrayList<Product> arrayOfProducts= new ArrayList<>();
    public static final String fileName="bakery.txt";
    public static void main(String[] args) throws WrongOwnerName, WrongBarcodeException, WrongPhoneNumberException, NoEnoughProducts {
        Scanner scanner=new Scanner(System.in);
        Validator validator=new Validator();
        WriterAndReader chetec=new WriterAndReader();

        ArrayList<Product> cakes=new ArrayList<>();
        ArrayList<Product> candies=new ArrayList<>();
        ArrayList<ChocolateBar> chocolates=new ArrayList<>();
        do{
            System.out.println("--------- Information about the OWNER:---------");
            System.out.println("Enter owner name: ");
            String OwnerName=scanner.nextLine();
            if(OwnerName.equals("end")){
                chetec.write();
                ArrayList<Product> arr=chetec.read();
                for(Product product:arr){
                  if(product.getBarcode().equals("@1@")){
                      cakes.add(product);
                  }else if(product.getBarcode().equals("@2@")){
                      candies.add(product);
                  }else if(product.getBarcode().equals("@3@")){
                      chocolates.add((ChocolateBar) product);
                  }
                }


                System.out.println("CAKES--->");
                for(int i=0;i<cakes.size();i++){
                    System.out.println("Cake "+i+1+" Barcode:"+cakes.get(i).getBarcode()+" Quantity:"+cakes.get(i).getQuantity()+" Price:"+cakes.get(i).getPrice());
                }

                System.out.println();
                System.out.println("CANDIES--->");
                for(int i=0;i<candies.size();i++){
                    System.out.println("Candy "+i+1+" Barcode:"+candies.get(i).getBarcode()+" Quantity:"+candies.get(i).getQuantity()+" Price:"+candies.get(i).getPrice());
                }

                System.out.println();
                System.out.println("CHOCOLATE BARS--->");
                for(int i=0;i<chocolates.size();i++){
                    System.out.println("Bar "+i+1+"  Barcode:"+chocolates.get(i).getBarcode()+" Price:"+chocolates.get(i).getPrice()+" Quantity:"+chocolates.get(i).getQuantity()+" Used Fruits:"+chocolates.get(i).getUsedFruits());
                }
                break;
            }
            validator.checkNameOfOwner(OwnerName);

            System.out.println("Enter owner address: ");
            String OwnerAddress=scanner.nextLine();

            System.out.println("Enter owner phone number: ");
            String OwnerPhoneNumber=scanner.nextLine();
            validator.checkPhoneNumber(OwnerPhoneNumber);

            Bakery owner=new Bakery(OwnerName,OwnerAddress,OwnerPhoneNumber);

            System.out.println();
            System.out.println("Enter your choice Cake | Candy | ChocolateBar:");
            String choice=scanner.nextLine();
            if(choice.equals("Cake")){
                System.out.println("Enter barcode: ");
                String barcode=scanner.nextLine();
                validator.checkBarcode(barcode);

                System.out.println("Enter price: ");
                double price=Double.parseDouble(scanner.nextLine());

                System.out.println("Enter quantity: ");
                int quantity=Integer.parseInt(scanner.nextLine());

                System.out.println("Enter grams: ");
                double grams=Double.parseDouble(scanner.nextLine());

                System.out.println("Enter are you used dark chocolate?[true/false]");
                boolean darkChocolate= Boolean.parseBoolean(scanner.nextLine());

                System.out.println("Колко броя искаш да продадеш?");
                int broi=Integer.parseInt(scanner.nextLine());

                Cake cake=new Cake(barcode,price,quantity,owner,grams,darkChocolate);
                arrayOfProducts.add(cake);

                System.out.println("End price: "+cake.getPromotionalPrice());
                System.out.println("Възможна ли е продажба: "+cake.sellProduct(broi));
                System.out.println("------ INFORMATION ABOUT PRODUCT ------");
                cake.getInformation();
            }else if(choice.equals("Candy")){
                System.out.println("Enter barcode: ");
                String barcode=scanner.nextLine();
                validator.checkBarcode(barcode);

                System.out.println("Enter price: ");
                double price=Double.parseDouble(scanner.nextLine());

                System.out.println("Enter quantity: ");
                int quantity=Integer.parseInt(scanner.nextLine());

                System.out.println("Enter type of candy:");
                String type=scanner.nextLine();

                System.out.println("Колко броя искаш да продадеш?");
                int broi=Integer.parseInt(scanner.nextLine());

                Candy candy=new Candy(barcode,price,quantity,owner,type);
                arrayOfProducts.add(candy);
                System.out.println("End price: "+candy.getPromotionalPrice());
                System.out.println("Възможна ли е продажба: "+candy.sellProduct(broi));
                System.out.println("------ INFORMATION ABOUT PRODUCT ------");
                candy.getInformation();
            }else if(choice.equals("ChocolateBar")){
                System.out.println("Enter barcode: ");
                String barcode=scanner.nextLine();
                validator.checkBarcode(barcode);

                System.out.println("Enter price: ");
                double price=Double.parseDouble(scanner.nextLine());

                System.out.println("Enter quantity: ");
                int quantity=Integer.parseInt(scanner.nextLine());

                System.out.println("Do you use fruits? ");
                String answearAboutFruits= scanner.nextLine();

                System.out.println("Колко броя искаш да продадеш?");
                int broi=Integer.parseInt(scanner.nextLine());

                ChocolateBar chocolateBar=new ChocolateBar(barcode,price,quantity,owner,answearAboutFruits);
                arrayOfProducts.add(chocolateBar);

                System.out.println("End price: "+chocolateBar.getPromotionalPrice());
                System.out.println("Възможна ли е продажба: "+chocolateBar.sellProduct(broi));
                System.out.println("------ INFORMATION ABOUT PRODUCT ------");
                chocolateBar.getInformation();

            }
        }while(true);
    }
}