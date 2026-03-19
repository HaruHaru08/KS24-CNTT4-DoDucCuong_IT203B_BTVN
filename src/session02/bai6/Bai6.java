package session02.bai6;

public class Bai6 {
    public static void main(String[] args) {
        User user = new User("nunu");
        UserProcessor processor = UserUtils::convertToUpperCase;

        String result = processor.process(user);

        System.out.println(result);
    }
}
