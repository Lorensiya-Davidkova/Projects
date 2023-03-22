import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable{
    private Socket socket;
    private Scanner poluchavaOtClient;
    private PrintStream izprashtaKumClient;


    public ClientHandler(Socket ClientSocket) throws IOException {
        this.socket=ClientSocket;
        this.poluchavaOtClient=new Scanner(socket.getInputStream());
        this.izprashtaKumClient=new PrintStream(socket.getOutputStream());
    }
    @Override
    public void run() {
        try{
           while(true){
               izprashtaKumClient.println("Въведи потребителско име:");
               String username = poluchavaOtClient.nextLine();
               if(username.equals("end")){
                   break;
               }
               izprashtaKumClient.println("Въведи парола:");
               String password = poluchavaOtClient.nextLine();
               User myUser = UserType(username, password);
               if(myUser==null){
                   izprashtaKumClient.println("Няма такъв потребител!");
               }else if(myUser.getClass().equals(Admin.class)){
                   //System.out.println("Въведеният потребител е АДМИНИСТРАТОР!");
                   AdminMenu(myUser,poluchavaOtClient,izprashtaKumClient);
               }else if(myUser.getClass().equals(Seller.class)){
                   // System.out.println("Въведеният потребител е ПРОДАВАЧ!");
                   //SellerMenu(myUser);
               }else if(myUser.getClass().equals(Domacin.class)){
                   //System.out.println("Въведеният потребител е ДОМАКИН!");
                   //DomacinMenu(myUser);
               }
           }
        } finally{
            poluchavaOtClient.close();
            izprashtaKumClient.close();
        }
    }
    public static User UserType(String username,String password){
        User toReturn=null;
        for(User user:Server.listOfUsers){
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

    public static void AdminMenu(User user,Scanner poluchavaOtClient,PrintStream izprashtaKumClient){
        Admin currentAdmin=(Admin)user;
        Validator validator=new Validator();
        izprashtaKumClient.println("Hello, Admin!");
       izprashtaKumClient.println("REGISTER | VIEW ALL PRODUCTS | VIEW ANIMAL:");
        String choice=poluchavaOtClient.nextLine();
            if (choice.equalsIgnoreCase("REGISTER")) {
                izprashtaKumClient.println("Ще регистрираш нов SELLER | DOMACIN:");
                String SDchoice = poluchavaOtClient.nextLine();
                if (SDchoice.equalsIgnoreCase("SELLER")) {
                    izprashtaKumClient.println("Въведи име на продавача, който ще регистрираш:");
                    String sellerUN = poluchavaOtClient.nextLine();
                    validator.checkSellerName(sellerUN);
                    izprashtaKumClient.println("Въведи парола на продавача, който ще регистрираш:");
                    String sellerP = poluchavaOtClient.nextLine();
                    System.out.println("Въведи телефонен номер на продавача, който ще регистрираш:");
                    String sellerPhone = poluchavaOtClient.nextLine();
                    User seller = new Seller(sellerUN, sellerP, sellerPhone);
                    Server.listOfUsers.add(seller);
                } else if (SDchoice.equalsIgnoreCase("DOMACIN")) {
                    izprashtaKumClient.println("Въведи име на домакина, който ще регистрираш:");
                    String domacinUN = poluchavaOtClient.nextLine();
                    validator.checkDomacinName(domacinUN);
                    izprashtaKumClient.println("Въведи парола на домакина, който ще регистрираш:");
                    String domacinP = poluchavaOtClient.nextLine();
                    izprashtaKumClient.println("Въведи телефонен номер на домакина, който ще регистрираш:");
                    String domacinPhone = poluchavaOtClient.nextLine();
                    User domacin = new Domacin(domacinUN, domacinP, domacinPhone);
                    Server.listOfUsers.add(domacin);
                }
        }else if(choice.equalsIgnoreCase("VIEW all products")){
            for(User user1:Server.listOfUsers){
                if(user1.getClass().equals(Seller.class)){
                    izprashtaKumClient.println("ПРОДАЖБИ НА:"+user1.getUsername());
                    for(int i=0;i<((Seller) user1).getListOfSellProducts().size();i++){
                        izprashtaKumClient.println(((Seller) user1).getListOfSellProducts().get(i).getName()+"   ID number->"+ ((Seller) user1).getListOfSellProducts().get(i).getIDnumber()+"   Price->"+((Seller) user1).getListOfSellProducts().get(i).getPrice());
                    }
                }
            }
        }else if(choice.equalsIgnoreCase("view animal")){
           izprashtaKumClient.println("ЕГН на животното:");
            String EGN=poluchavaOtClient.nextLine();
            Animal otkrito=null;
            for(Animal zdravo:Server.listOfZdraviJivotni){
                if(zdravo.getAnimalEGN().equals(EGN)){
                    otkrito=zdravo;
                }
            }
            for(Animal bolno:Server.listOfBolniJivotni){
                if(bolno.getAnimalEGN().equals(EGN)){
                    otkrito=bolno;
                }
            }
            if(otkrito==null){
                throw new IllegalArgumentException();
            }else{
                izprashtaKumClient.println("Има таково животно!");
                izprashtaKumClient.println("--- "+otkrito.getAnimalEGN()+" ---");
                izprashtaKumClient.println("--- "+otkrito.getName()+" ---");
                izprashtaKumClient.println("--- "+otkrito.getAge()+" ---");
            }
        }
    }
}
