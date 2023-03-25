import java.util.ArrayList;
import java.util.Scanner;
public class Server {
    public static ArrayList<User> listOfUsers=new ArrayList<>();
    public static ArrayList<Animal> listOfZdraviJivotni=new ArrayList<>();
    public static ArrayList<Animal> listOfBolniJivotni=new ArrayList<>();

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        Validator validator=new Validator();

        User admin=new Admin("admin","123456","0887787405");
        listOfUsers.add(admin);

        //admin-> {"admin","admin9","0887784704"}
        //seller->{"Seller","seller9","0887784705"," "}
        //domacin->{"&domacin,"domacin9","0887784706"}
        do {
            System.out.println("Въведи потребителско име:");
            String username = scanner.nextLine();
            if(username.equals("end")){
                break;
            }
            System.out.println("Въведи парола:");
            String password = scanner.nextLine();
            User myUser = UserType(username, password);
            if(myUser==null){
                System.out.println("Няма такъв потребител!");
            }else if(myUser.getClass().equals(Admin.class)){
                //System.out.println("Въведеният потребител е АДМИНИСТРАТОР!");
                AdminMenu(myUser);
            }else if(myUser.getClass().equals(Seller.class)){
               // System.out.println("Въведеният потребител е ПРОДАВАЧ!");
                SellerMenu(myUser);
            }else if(myUser.getClass().equals(Domacin.class)){
                //System.out.println("Въведеният потребител е ДОМАКИН!");
                DomacinMenu(myUser);
            }
        }while(true);
    }


    public static void SellerMenu(User user){
        Scanner scanner=new Scanner(System.in);
        Validator validator=new Validator();
        Seller currentSeller=(Seller) user;
        System.out.println("Hello, Seller!");
        System.out.println("Въведи телефонен номер:");
        String phoneNumber=scanner.nextLine();
        validator.checkPhoneNumber(phoneNumber);
        System.out.println("Въведи име на продадения продукт:");
        String nameSoldProduct=scanner.nextLine();
        System.out.println("Въвведи ID номер на продадения продукт:");
        String IDnumber=scanner.nextLine();
        System.out.println("Въведи цена на продадения продукт:");
        double price=Double.parseDouble(scanner.nextLine());
        Product soldProduct=new Product(nameSoldProduct,IDnumber,price);
        currentSeller.getListOfSellProducts().add(soldProduct);
    }

    public static void DomacinMenu(User user){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Hello, Domacin!");
        Domacin currentDomacin=(Domacin)user;
        System.out.println("REGISTRATION | FEEDING:");
        String choice=scanner.nextLine();
        if(choice.equalsIgnoreCase("Registration")){
            System.out.println("Въведи ЕГН на животното:");
            String AnimalEGN=scanner.nextLine();
            System.out.println("Въведи име на животното:");
            String AnimalName=scanner.nextLine();
            System.out.println("Въведи години на животното:");
            int age=Integer.parseInt(scanner.nextLine());
            Animal animal=new Animal(AnimalEGN,AnimalName,age);
            System.out.println("ZDRAVO | BOLNO:");
            String animalType=scanner.nextLine();
            if(animalType.equalsIgnoreCase("Zdravo")){
                listOfZdraviJivotni.add(animal);
            }else if(animalType.equalsIgnoreCase("Bolno")){
                listOfBolniJivotni.add(animal);
            }
        }else if(choice.equalsIgnoreCase("feeding")){
            System.out.println("Въведи потребителско име на продавача  на смаяна: ");
            String sellerN=scanner.nextLine();
            System.out.println("Въведи парола на продавача на смяна: ");
            String passN=scanner.nextLine();
            System.out.println("Въведи телефонен номер на продавача на смяна: ");
            String phoneN=scanner.nextLine();
            User prodavachNaSmqna=null;
            for(User user1:listOfUsers){
                if(user1.getClass().equals(Seller.class)){
                    if(user1.getUsername().equals(sellerN) && user1.getPassword().equals(passN) && user1.getPhoneNumber().equals(phoneN)){
                       prodavachNaSmqna=user1;
                    }
                }
            }
            if(prodavachNaSmqna==null){
                System.out.println("Няма такъв продавач на смяна!");
            }else{
                Seller prodavach=(Seller)prodavachNaSmqna;
                System.out.println("Въведи име на продукта:");
                String nameFood=scanner.nextLine();
                System.out.println("Номер на продукта:");
                String IDFood=scanner.nextLine();
                System.out.println("Цена на продукта:");
                double PriceFood=Double.parseDouble(scanner.nextLine());
                Product givenProduct=new Product(nameFood,IDFood,PriceFood);
                prodavach.getListOfSellProducts().add(givenProduct);
            }
        }
    }

    public static void AdminMenu(User user){
        Admin currentAdmin=(Admin)user;
        Scanner scanner=new Scanner(System.in);
        Validator validator=new Validator();
        System.out.println("Hello, Admin!");
        System.out.println("REGISTER | VIEW ALL PRODUCTS | VIEW ANIMAL:");
        String choice=scanner.nextLine();
        if(choice.equalsIgnoreCase("REGISTER")){
            System.out.println("Ще регистрираш нов SELLER | DOMACIN:");
            String SDchoice=scanner.nextLine();
            if(SDchoice.equalsIgnoreCase("SELLER")){
                System.out.println("Въведи име на продавача, който ще регистрираш:");
                String sellerUN=scanner.nextLine();
                validator.checkSellerName(sellerUN);
                System.out.println("Въведи парола на продавача, който ще регистрираш:");
                String sellerP=scanner.nextLine();
                System.out.println("Въведи телефонен номер на продавача, който ще регистрираш:");
                String sellerPhone=scanner.nextLine();
                User seller=new Seller(sellerUN,sellerP,sellerPhone);
                listOfUsers.add(seller);
            }else if(SDchoice.equalsIgnoreCase("DOMACIN")){
                System.out.println("Въведи име на домакина, който ще регистрираш:");
                String domacinUN=scanner.nextLine();
                validator.checkDomacinName(domacinUN);
                System.out.println("Въведи парола на домакина, който ще регистрираш:");
                String domacinP=scanner.nextLine();
                System.out.println("Въведи телефонен номер на домакина, който ще регистрираш:");
                String domacinPhone=scanner.nextLine();
                User domacin=new Domacin(domacinUN,domacinP,domacinPhone);
                listOfUsers.add(domacin);
            }
        }else if(choice.equalsIgnoreCase("VIEW all products")){
            for(User user1:listOfUsers){
                if(user1.getClass().equals(Seller.class)){
                    System.out.println("ПРОДАЖБИ НА:"+user1.getUsername());
                    for(int i=0;i<((Seller) user1).getListOfSellProducts().size();i++){
                        System.out.println(((Seller) user1).getListOfSellProducts().get(i).getName()+"   ID number->"+ ((Seller) user1).getListOfSellProducts().get(i).getIDnumber()+"   Price->"+((Seller) user1).getListOfSellProducts().get(i).getPrice());
                    }
                }
            }
        }else if(choice.equalsIgnoreCase("view animal")){
            System.out.println("ЕГН на животното:");
            String EGN=scanner.nextLine();
            Animal otkrito=null;
            for(Animal zdravo:listOfZdraviJivotni){
                if(zdravo.getAnimalEGN().equals(EGN)){
                    otkrito=zdravo;
                }
            }
            for(Animal bolno:listOfBolniJivotni){
                if(bolno.getAnimalEGN().equals(EGN)){
                    otkrito=bolno;
                }
            }
            if(otkrito==null){
                throw new IllegalArgumentException();
            }else{
                System.out.println("Има таково животно!");
                System.out.println("--- "+otkrito.getAnimalEGN()+" ---");
                System.out.println("--- "+otkrito.getName()+" ---");
                System.out.println("--- "+otkrito.getAge()+" ---");
            }
        }
    }

    public static User UserType(String username,String password){
        User toReturn=null;
        for(User user:listOfUsers){
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                if(user.getClass().equals(Admin.class)){
                    toReturn=(Admin)user;
                }else if(user.getClass().equals(Seller.class)){
                    toReturn=(Seller)user;
                }else if(user.getClass().equals(Domacin.class)){
                    toReturn=(Domacin)user;
                }
            }
        }
        return toReturn;
    }
}
