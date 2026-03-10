package session03.bai2;

public class User {
    String username;
    String email;
    String status;

    public User() {
    }

    public User(String username, String email, String status) {
        this.username = username;
        this.email = email;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
