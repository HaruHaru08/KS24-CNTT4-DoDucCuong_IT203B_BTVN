package session03.bai6;

import java.util.List;

public class Post {
    List<String> tags;

    public Post(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getTags() {
        return tags;
    }
}
