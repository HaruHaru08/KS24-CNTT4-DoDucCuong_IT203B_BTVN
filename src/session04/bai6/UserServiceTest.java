package session04.bai6;

import org.junit.jupiter.api.*;
import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    UserService service;
    User existingUser;
    List<User> allUsers;

    @BeforeEach
    void setUp() {
        service = new UserService();
        existingUser = new User(
                "old@mail.com",
                LocalDate.of(2000,1,1),
                "Old Name"
        );
        allUsers = new ArrayList<>();
        allUsers.add(existingUser);
    }

    @AfterEach
    void tearDown() {
        existingUser = null;
        allUsers = null;
    }

    @Test
    void updateProfile_success_whenEmailAndBirthDateValid() {
        UserProfile newProfile = new UserProfile(
                "new@mail.com",
                LocalDate.of(1999,1,1),
                "New Name"
        );
        User result = service.updateProfile(existingUser, newProfile, allUsers);
        assertNotNull(result);
    }

    @Test
    void updateProfile_fail_whenBirthDateIsInFuture() {
        UserProfile newProfile = new UserProfile(
                "new@mail.com",
                LocalDate.now().plusDays(1),
                "New Name"
        );
        User result = service.updateProfile(existingUser, newProfile, allUsers);
        assertNull(result);
    }

    @Test
    void updateProfile_fail_whenEmailAlreadyExists() {
        User otherUser = new User(
                "duplicate@mail.com",
                LocalDate.of(1995,1,1),
                "Other"
        );
        allUsers.add(otherUser);
        UserProfile newProfile = new UserProfile(
                "duplicate@mail.com",
                LocalDate.of(1999,1,1),
                "New Name"
        );
        User result = service.updateProfile(existingUser, newProfile, allUsers);
        assertNull(result);
    }

    @Test
    void updateProfile_success_whenEmailSameAsCurrent() {
        UserProfile newProfile = new UserProfile(
                "old@mail.com",
                LocalDate.of(1999,1,1),
                "Updated Name"
        );
        User result = service.updateProfile(existingUser, newProfile, allUsers);
        assertNotNull(result);
    }

    @Test
    void updateProfile_success_whenUserListEmpty() {
        allUsers.clear();
        UserProfile newProfile = new UserProfile(
                "new@mail.com",
                LocalDate.of(1999,1,1),
                "New Name"
        );

        User result = service.updateProfile(existingUser, newProfile, allUsers);
        assertNotNull(result);
    }

    @Test
    void updateProfile_fail_whenEmailDuplicateAndBirthDateFuture() {
        User otherUser = new User(
                "duplicate@mail.com",
                LocalDate.of(1995,1,1),
                "Other"
        );
        allUsers.add(otherUser);
        UserProfile newProfile = new UserProfile(
                "duplicate@mail.com",
                LocalDate.now().plusDays(5),
                "New Name"
        );
        User result = service.updateProfile(existingUser, newProfile, allUsers);
        assertNull(result);
    }
}