package session08.bai1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Device> devices = new ArrayList<>();
        HardwareConnection hardwareConnection = null;

        while (true) {
            System.out.println("1. Kết nối phần cứng");
            System.out.println("2. Tạo thiết bị mới");
            System.out.println("3. Bật thiết bị");
            System.out.println("4. Tạo thêm thiết bị");
            System.out.println("5. Kiểm tra Singleton");
            System.out.println("6. Thoát");
            System.out.print("Chọn: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    hardwareConnection = HardwareConnection.getInstance();
                    break;
                case 2:
                    System.out.println("Chọn loại: 1. Đèn, 2. Quạt, 3. Điều hòa");
                    System.out.print("Chọn: ");
                    int type = scanner.nextInt();
                    DeviceFactory factory = null;
                    if (type == 1) {
                        factory = new LightFactory();
                    } else if (type == 2) {
                        factory = new FanFactory();
                    } else if (type == 3) {
                        factory = new AirConditionerFactory();
                    }

                    if (factory != null) {
                        Device device = factory.createDevice();
                        devices.add(device);
                    }
                    break;
                case 3:
                    if (devices.isEmpty()) {
                        System.out.println("Chưa có thiết bị nào để bật.");
                    } else {
                        System.out.print("Chọn thiết bị vừa tạo: ");
                        int deviceIndex = scanner.nextInt();
                        if (deviceIndex > 0 && deviceIndex <= devices.size()) {
                            // Assuming 1-based index from the prompt "Chọn thiết bị vừa tạo: 1"
                            devices.get(deviceIndex - 1).turnOn();
                        } else {
                            System.out.println("Thiết bị không tồn tại.");
                        }
                    }
                    break;
                case 4:
                    // Similar to case 2, as per prompt "4. Tạo thêm thiết bị" which then asks "Chọn loại: 2"
                    System.out.println("Chọn loại: 1. Đèn, 2. Quạt, 3. Điều hòa");
                    System.out.print("Chọn: ");
                    int typeMore = scanner.nextInt();
                    DeviceFactory factoryMore = null;
                    if (typeMore == 1) {
                        factoryMore = new LightFactory();
                    } else if (typeMore == 2) {
                        factoryMore = new FanFactory();
                    } else if (typeMore == 3) {
                        factoryMore = new AirConditionerFactory();
                    }

                    if (factoryMore != null) {
                        Device device = factoryMore.createDevice();
                        devices.add(device);
                    }
                    break;
                case 5:
                    System.out.println("Gọi kết nối lần 2");
                    HardwareConnection.getInstance();
                    break;
                case 6:
                    return;
            }
        }
    }
}
