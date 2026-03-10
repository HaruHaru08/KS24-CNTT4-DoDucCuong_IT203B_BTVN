package session03.bai4;

import java.util.*;
import java.util.stream.Collectors;

record User(String username, String email) {}

public class Bai4 {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("alice", "alice1@gmail.com"),
                new User("bob", "bob@yahoo.com"),
                new User("alice", "alice2@gmail.com"),
                new User("charlie", "charlie@gmail.com")
        );
        List<User> uniqueUsers =
                users.stream()
                        .collect(Collectors.toMap(
                                User::username,
                                user -> user,
                                (u1, u2) -> u1
                        ))
                        .values()
                        .stream()
                        .toList();
        uniqueUsers.forEach(System.out::println);
    }
}
