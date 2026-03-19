package session02.bai2;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        PasswordValidator validPass = password -> password.length() >= 8;

        String password;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào password cần kiểm tra: ");
        password = sc.nextLine();

        if(validPass.isValid(password)){
            System.out.println("Password này hợp lệ!");
        }else{
            System.out.println("Password này không hợp lệ!");
        }

    }
}
