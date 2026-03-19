package session04.bai2;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    UserService service;

    @BeforeEach
    void setUp() {
        service = new UserService();
    }

    @Test
    void TC01_age18_validBoundary() {
        int age = 18;
        boolean result = service.checkRegistrationAge(age);
        if (result) {
            System.out.println("Hợp lệ");
        }
        assertEquals(true, result);
    }

    @Test
    void TC02_age17_invalid() {
        int age = 17;
        boolean result = service.checkRegistrationAge(age);
        if (!result) {
            System.out.println("Không hợp lệ");
        }
        assertEquals(false, result);
    }

    @Test
    void TC03_negativeAge_exception() {
        int age = -1;
        assertThrows(IllegalArgumentException.class, () -> {
            service.checkRegistrationAge(age);
        });
    }
}