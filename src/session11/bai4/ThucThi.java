package session11.bai4;

public class ThucThi {
    public static String sanitizeInput(String input) {
        if (input == null) return null;

        return input
                .replace("--", "")
                .replace(";", "")
                .replace("'", "");
    }
}
