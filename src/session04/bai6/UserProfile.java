package session04.bai6;

import java.time.LocalDate;

public class UserProfile {
    private String email;
    private LocalDate birthDate;
    private String name;

    public UserProfile(String email, LocalDate birthDate, String name) {
        this.email = email;
        this.birthDate = birthDate;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getName() {
        return name;
    }
}