import java.io.*;
import java.util.ArrayList;

public class WriterAndReader {
    public void write() {
        try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("bakery.txt"))){
            out.writeObject(Main.arrayOfProducts);
            out.flush();
            out.close();
        }catch(IOException e) {
            e.getMessage();
        }
    }
    public ArrayList<Product> read(){
        ArrayList<Product> arrayOfProducts=new ArrayList<>();
        try(ObjectInputStream in=new ObjectInputStream(new FileInputStream("bakery.txt"))){
           arrayOfProducts=(ArrayList<Product>)in.readObject();
        }catch(IOException e){
            e.getMessage();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return arrayOfProducts;
    }
}
