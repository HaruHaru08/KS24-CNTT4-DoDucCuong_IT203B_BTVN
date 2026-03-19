package session03.bai5;
import java.util.List;
import java.util.Comparator;

record User(String username, String email) {}
public class Bai5 {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("alex", "alex@gmail.com"),
                new User("alexander", "alexander@gmail.com"),
                new User("charlotte", "charlotte@gmail.com"),
                new User("Ben", "ben@gmail.com"),
                new User("Benjamin", "benjamin@gmail.com")
        );

        users.stream()
                .sorted(Comparator.comparingInt((User u) -> u.username().length()).reversed())
                .limit(3)
                .map(User::username)
                .forEach(System.out::println);
    }
}
