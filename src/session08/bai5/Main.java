package session08.bai5;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Devices
        Light light = new Light();
        Fan fan = new Fan();
        AirConditioner ac = new AirConditioner();

        // Observer
        TemperatureSensor sensor = new TemperatureSensor();
        sensor.attach(fan);
        sensor.attach(ac);

        // Commands
        Command sleepMode = new SleepModeCommand(Arrays.asList(
                new LightOffCommand(light),
                new SetACTemperatureCommand(ac),
                new FanLowCommand(fan)
        ));

        while (true) {
            System.out.println("\n1. Kích hoạt chế độ ngủ");
            System.out.println("2. Thay đổi nhiệt độ");
            System.out.println("3. Xem trạng thái");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sleepMode.execute();
                    break;

                case 2:
                    System.out.print("Nhập nhiệt độ: ");
                    int temp = sc.nextInt();
                    sensor.setTemperature(temp);
                    break;

                case 3:
                    fan.status();
                    ac.status();
                    break;

                case 0:
                    System.exit(0);
            }
        }
    }
}
