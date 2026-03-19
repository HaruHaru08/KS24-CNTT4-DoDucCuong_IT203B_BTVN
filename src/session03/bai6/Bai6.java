package session03.bai6;

import java.util.List;

public class Bai6 {
    public static void main(String[] args) {

        List<Post> posts = List.of(
                new Post(List.of("java", "backend")),
                new Post(List.of("python", "data"))
        );

        List<String> allTags = posts.stream()
                .flatMap(post -> post.getTags().stream())
                .toList();

        System.out.println(allTags);
    }
}
