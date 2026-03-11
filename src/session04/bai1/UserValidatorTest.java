package session04.bai1;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class UserValidatorTest {

    UserValidator validator;

    @BeforeEach
    void setUp() {
        validator = new UserValidator();
    }

    @Test
    void TC01_validUsername() {
        String username = "user123";
        boolean result = validator.isValidUsername(username);
        if (result) {
            System.out.println("Hợp lệ");
        }
        assertTrue(result);
    }

    @Test
    void TC02_usernameTooShort() {
        String username = "abc";
        boolean result = validator.isValidUsername(username);
        if (!result) {
            System.out.println("Quá ngắn");
        }
        assertFalse(result);
    }

    @Test
    void TC03_usernameContainsSpace() {
        String username = "user name";
        boolean result = validator.isValidUsername(username);
        if (!result) {
            System.out.println("Chứa khoảng trắng");
        }
        assertFalse(result);
    }
}