import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public void checkNameOfOwner(String name) throws WrongOwnerName{
        String regex="^([A-Z]{1}[a-z]+)$";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(name);
        if(matcher.find()){

        }else{
            throw new WrongOwnerName();
        }
    }

    public void checkPhoneNumber(String phoneNumber) throws WrongPhoneNumberException{
        String regex="^([0-9]{10})$";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(phoneNumber);
        if(!matcher.find()){
            throw new WrongPhoneNumberException();
        }
    }

    public void checkBarcode(String barcode) throws WrongBarcodeException{
        String regex="^(@[123]@)$";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(barcode);
        if(!matcher.find()){
            throw new WrongBarcodeException();
        }
    }

}
