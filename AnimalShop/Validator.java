import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public void checkPhoneNumber(String phoneNumber){
        String regex="^[0-9]{10}$";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(phoneNumber);
        if(!matcher.find()){
            throw new IllegalArgumentException();
        }
    }

    public void checkSellerName(String sellerName){
        String regex="^[A-Z][a-z]{5,}$";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(sellerName);
        if(!matcher.find()){
            throw new IllegalArgumentException();
        }
    }

    public void checkDomacinName(String DomacinName){
        String regex="(&[a-z]{5,9})";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(DomacinName);
        if(!matcher.find()){
            throw new IllegalArgumentException();
        }
    }
}
