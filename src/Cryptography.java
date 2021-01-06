
import java.security.*;

public class Cryptography {

    //input text, output cipher encrypted with SHA-512
    public static String encrypt(final String plainText) {
        String cipher = null;
        if (plainText != null && plainText.length() > 0) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
                messageDigest.update(plainText.getBytes());
                byte[] byteBuffer = messageDigest.digest();
                StringBuilder stringBuilder = new StringBuilder();
                for (byte b : byteBuffer) {
                    String hex = Integer.toHexString(0xff & b);
                    if (hex.length() == 1) {
                        stringBuilder.append('0');
                    }
                    stringBuilder.append(hex);
                }
                cipher = stringBuilder.toString();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return cipher;
    }

}

