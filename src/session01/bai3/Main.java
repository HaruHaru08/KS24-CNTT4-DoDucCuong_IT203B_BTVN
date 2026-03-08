package session01.bai3;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.setAge(20);
        System.out.println("Tuổi: " + user.getAge());
        user.setAge(-12);
    }
}
