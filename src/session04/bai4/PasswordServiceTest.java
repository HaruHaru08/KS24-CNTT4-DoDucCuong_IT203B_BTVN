package session04.bai4;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class PasswordServiceTest {
    PasswordService service;

    @BeforeEach
    void setUp() {
        service = new PasswordService();
    }

    @Test
    void evaluatePasswordStrength_variousPasswords() {
        assertAll(
                () -> {
                    String input = "Abc123!@";
                    String r = service.evaluatePasswordStrength(input);
                    System.out.println("TC01:Mạnh");
                    assertEquals("Mạnh", r);
                },

                () -> {
                    String input = "abc123!@";
                    String r = service.evaluatePasswordStrength(input);
                    System.out.println("TC02:Trung bình");
                    assertEquals("Trung bình", r);
                },

                () -> {
                    String input = "ABC123!@";
                    String r = service.evaluatePasswordStrength(input);
                    System.out.println("TC03:Trung bình");
                    assertEquals("Trung bình", r);
                },

                () -> {
                    String input = "Abcdef!@";
                    String r = service.evaluatePasswordStrength(input);
                    System.out.println("TC04:Trung bình");
                    assertEquals("Trung bình", r);
                },

                () -> {
                    String input = "Abc12345";
                    String r = service.evaluatePasswordStrength(input);
                    System.out.println("TC05:Trung bình");
                    assertEquals("Trung bình", r);
                },

                () -> {
                    String input = "Ab1!";
                    String r = service.evaluatePasswordStrength(input);
                    System.out.println("TC06:Yếu");
                    assertEquals("Yếu", r);
                },

                () -> {
                    String input = "password";
                    String r = service.evaluatePasswordStrength(input);
                    System.out.println("TC07:Yếu");
                    assertEquals("Yếu", r);
                },

                () -> {
                    String input = "ABC12345";
                    String r = service.evaluatePasswordStrength(input);
                    System.out.println("TC08:Yếu");
                    assertEquals("Yếu", r);
                }
        );
    }
}