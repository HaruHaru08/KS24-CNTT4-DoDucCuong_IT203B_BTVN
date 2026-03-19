package session03.bai3;

import java.util.Optional;

public class Bai3 {
    public static void main(String[] args) {
        UserRepository repo = new UserRepository();

        Optional<User> user = repo.findUserByUsername("alice");

        if (user.isPresent()) {
            System.out.println("Welcome " + user.get().getUsername());
        } else {
            System.out.println("Guest login");
        }
    }
}
