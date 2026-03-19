package session01.bai6;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Nhập tên người dùng: ");
            String name = sc.nextLine();
            User user = new User(name);
            System.out.print("Nhập tuổi: ");
            int age = Integer.parseInt(sc.nextLine());
            user.setAge(age);
            if (user.getName() != null) {
                System.out.println("Xin chào: " + user.getName());
            }
            System.out.println("Tuổi: " + user.getAge());

            System.out.print("Nhập tổng số người: ");
            int total = sc.nextInt();

            System.out.print("Nhập số nhóm: ");
            int groups = sc.nextInt();

            int result = total / groups;

            System.out.println("Mỗi nhóm có: " + result + " người");

            UserService.processUserData();

        }
        catch (NumberFormatException e) {
            Logger.logError("Sai định dạng số: " + e.getMessage());
        }
        catch (ArithmeticException e) {
            Logger.logError("Không thể chia cho 0");
        }
        catch (InvalidAgeException e) {
            Logger.logError("Lỗi tuổi người dùng: " + e.getMessage());
        }
        catch (IOException e) {
            Logger.logError("Lỗi hệ thống file: " + e.getMessage());
        }
        finally {
            sc.close();
            System.out.println("Dọn dẹp tài nguyên...");
        }
        System.out.println("Chương trình kết thúc an toàn.");
    }
}
