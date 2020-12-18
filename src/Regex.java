import java.util.regex.*;

public class Regex {

    //Check if the password is valid
    public static boolean checkPassword(String password){
        String correctPattern = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])(?=.*[^a-zA-Z0-9])(.{8,32})$";
        return Pattern.matches(correctPattern, password);
    }

}
