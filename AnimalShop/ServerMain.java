import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ServerMain {
    public static ArrayList<User> listOfUsers=new ArrayList<>();
    public static ArrayList<Animal> listOfZdraviJivotni=new ArrayList<>();
    public static ArrayList<Animal> listOfBolniJivotni=new ArrayList<>();

    public static void main(String[] args) throws IOException {

        User admin=new Admin("admin","123456","0887787405");
        listOfUsers.add(admin);

        ServerSocket server=new ServerSocket(8080);
        while(true){
            System.out.println("[SERVER] Waiting for client connect");
            Socket socket=server.accept();
            System.out.println("[SERVER] Connected to client!");

            ClientHandler clientThread=new ClientHandler(socket);
            clientThread.run();
        }
    }
}
