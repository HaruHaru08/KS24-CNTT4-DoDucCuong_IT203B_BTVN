package session08.bai2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // dùng cảm biến cũ qua Adapter
        OldThermometer oldThermometer = new OldThermometer();
        TemperatureSensor sensor = new ThermometerAdapter(oldThermometer);

        SmartHomeFacade home = new SmartHomeFacade(sensor);

        while (true) {
            System.out.println("\n1. Xem nhiệt độ");
            System.out.println("2. Rời nhà");
            System.out.println("3. Chế độ ngủ");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    home.getCurrentTemperature();
                    break;
                case 2:
                    home.leaveHome();
                    break;
                case 3:
                    home.sleepMode();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}
