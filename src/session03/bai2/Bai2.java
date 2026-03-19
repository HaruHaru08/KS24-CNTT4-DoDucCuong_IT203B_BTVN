package session03.bai2;

import java.util.ArrayList;
import java.util.List;

public class Bai2 {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        users.add(new User("alice", "alice@gmail.com", "ACTIVE"));
        users.add(new User("bob", "bob@yahoo.com", "INACTIVE"));
        users.add(new User("charlie", "charlie@gmail.com", "ACTIVE"));

        users.stream()
                .filter(user -> user.getEmail().endsWith("@gmail.com"))
                .map(User::getUsername)
                .forEach(System.out::println);
    }
}
