package session02.bai3;

import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        System.out.println("Mã hoá dữ liệu: ");
        System.out.println("Nhập vào dữ liệu cần mã hoá: ");
        Scanner sc = new Scanner(System.in);
        String password = sc.nextLine();
        System.out.println("Mật khẩu mã hoá: "+Authenticatable.encrypt(password));
    }
}
