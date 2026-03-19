package session04.bai6;

import java.time.LocalDate;

public class User {
    private String email;
    private LocalDate birthDate;
    private String name;

    public User(String email, LocalDate birthDate, String name) {
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

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setName(String name) {
        this.name = name;
    }
}