package session01.bai5;

import session01.bai5.User;

public class Main {
    public static void main(String[] args) {

        User user = new User();

        try {
            user.setAge(-5);
        } catch (InvalidAgeException e) {
            System.out.println("Lỗi nghiệp vụ: " + e.getMessage());
        }

        System.out.println("Chương trình vẫn tiếp tục chạy.");
    }
}
