package session04.bai5;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class PermissionServiceTest {

    PermissionService service;
    User user;

    @BeforeEach
    void setUp() {
        service = new PermissionService();
    }

    @AfterEach
    void tearDown() {
        user = null;
    }

    @Test
    void testPermissionMatrix() {
        assertAll(
                // ADMIN
                () -> {
                    user = new User("ADMIN");
                    boolean result = service.canPerformAction(user, "DELETE_USER");
                    assertTrue(result);
                },
                () -> {
                    user = new User("ADMIN");
                    boolean result = service.canPerformAction(user, "LOCK_USER");
                    assertTrue(result);
                },
                () -> {
                    user = new User("ADMIN");
                    boolean result = service.canPerformAction(user, "VIEW_PROFILE");
                    assertTrue(result);
                },
                // MODERATOR
                () -> {
                    user = new User("MODERATOR");
                    boolean result = service.canPerformAction(user, "DELETE_USER");
                    assertFalse(result);
                },
                () -> {
                    user = new User("MODERATOR");
                    boolean result = service.canPerformAction(user, "LOCK_USER");
                    assertTrue(result);
                },
                () -> {
                    user = new User("MODERATOR");
                    boolean result = service.canPerformAction(user, "VIEW_PROFILE");
                    assertTrue(result);
                },
                // USER
                () -> {
                    user = new User("USER");
                    boolean result = service.canPerformAction(user, "DELETE_USER");
                    assertFalse(result);
                },
                () -> {
                    user = new User("USER");
                    boolean result = service.canPerformAction(user, "LOCK_USER");
                    assertFalse(result);
                },
                () -> {
                    user = new User("USER");
                    boolean result = service.canPerformAction(user, "VIEW_PROFILE");
                    assertTrue(result);
                }
        );
    }
}