package hellojdbc.hellojdbc.uteis;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class Password {

    public static String encriptPassword(String password)  {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(password.getBytes(StandardCharsets.UTF_8));
            return new BigInteger(1, messageDigest.digest()).toString(16);
        }catch (Exception ignored){}
        return null;
    }
}