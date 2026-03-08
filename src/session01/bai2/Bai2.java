package session01.bai2;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Nhập tổng số người dùng: ");
            int tongNguoi = sc.nextInt();

            System.out.print("Nhập số lượng nhóm muốn chia: ");
            int soNhom = sc.nextInt();

            int ketQua = tongNguoi / soNhom;

            System.out.println("Mỗi nhóm có: " + ketQua + " người");

        } catch (ArithmeticException e) {
            System.out.println("Không thể chia cho 0!");
        } finally {
            sc.close();
            System.out.println("Kết thúc chương trình.");
        }
    }
}
