package session02.bai4;

import java.util.*;
import java.util.function.*;

public class Bai4 {
    public static void main(String[] args) {

        List<User> users = new ArrayList<>();
        users.add(new User("admin"));
        users.add(new User("john"));
        users.add(new User("anna"));

        // 1. (user) -> user.getUsername()
        Function<User, String> getName = User::getUsername;

        // 2. (s) -> System.out.println(s)
        Consumer<String> print = System.out::println;

        // 3. () -> new User()
        Supplier<User> createUser = User::new;
    }
}
