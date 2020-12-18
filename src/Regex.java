import java.util.regex.*;

public class Regex {

    public static boolean verifyPassword(String password){
        String correctPattern = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])(?=.*[^a-zA-Z0-9])(.{8,32})$";
        return Pattern.matches(correctPattern, password);
    }

    public static void main(String args[]) {
        System.out.println(verifyPassword("0a!a0a!a0a!aA0a!a0a!a0a!aA0a!a0a!a0a!aA"));
    }
}
