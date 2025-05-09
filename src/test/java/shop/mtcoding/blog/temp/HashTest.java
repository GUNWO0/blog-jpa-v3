package shop.mtcoding.blog.temp;

import org.junit.jupiter.api.Test;
import org.mindrot.jbcrypt.BCrypt;


public class HashTest {
    @Test
    public void encode_test() {
        // $2a$10$eHhnWr07eL9R2.0YT8fkoeGlacSJYpZSsdKkzXC8VZSdXu7KM6k5q
        // $2a$10$wbqKRpNQScN7ZyvOxMEOwey5BjrIll62Wc7M/ZW6diPi6RjrZEXrm
        String password = "1234";

        String encodedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        System.out.println(encodedPassword);
    }

    @Test
    public void decode_test() {
        // $2a$10$eHhnWr07eL9R2.0YT8fkoeGlacSJYpZSsdKkzXC8VZSdXu7KM6k5q
        // $2a$10$wbqKRpNQScN7ZyvOxMEOwey5BjrIll62Wc7M/ZW6diPi6RjrZEXrm
        String dbPassword = "$2a$10$eHhnWr07eL9R2.0YT8fkoeGlacSJYpZSsdKkzXC8VZSdXu7KM6k5q";
        String password = "1234";

        String encodedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        if (dbPassword.equals(encodedPassword)) {
            System.out.println(encodedPassword);
            System.out.println("비밀번호가 같아요");
        } else {
            System.out.println("비밀번호가 달라요");
        }
    }

    @Test
    public void decodeV2_test() {
        // $2a$10$eHhnWr07eL9R2.0YT8fkoeGlacSJYpZSsdKkzXC8VZSdXu7KM6k5q
        // $2a$10$wbqKRpNQScN7ZyvOxMEOwey5BjrIll62Wc7M/ZW6diPi6RjrZEXrm
        String dbPassword = "$2a$10$eHhnWr07eL9R2.0YT8fkoeGlacSJYpZSsdKkzXC8VZSdXu7KM6k5q";
        String password = "1234";

        Boolean isSame = BCrypt.checkpw(password, dbPassword);
        System.out.println(isSame);
    }
}
