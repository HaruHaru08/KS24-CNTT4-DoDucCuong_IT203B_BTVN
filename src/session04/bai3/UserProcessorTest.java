package session04.bai3;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class UserProcessorTest {
    UserProcessor processor;

    @BeforeEach
    void setUp() {
        processor = new UserProcessor();
    }

    @Test
    void processEmail_validEmail_returnsSameEmail() {
        String email = "user@gmail.com";
        String result = processor.processEmail(email);
        assertEquals("user@gmail.com", result);
    }

    @Test
    void processEmail_missingAtSymbol_throwsException() {
        String email = "usergmail.com";
        assertThrows(IllegalArgumentException.class, () -> {
            processor.processEmail(email);
        });
    }

    @Test
    void processEmail_missingDomain_throwsException() {
        String email = "user@";
        assertThrows(IllegalArgumentException.class, () -> {
            processor.processEmail(email);
        });
    }

    @Test
    void processEmail_uppercaseEmail_returnsLowercase() {
        String email = "Example@Gmail.com";
        String result = processor.processEmail(email);
        assertEquals("example@gmail.com", result);
    }
}