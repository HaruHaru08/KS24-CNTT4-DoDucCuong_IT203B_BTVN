package session01.bai6;

import java.io.IOException;

public class UserService {
    public static void saveToFile() throws IOException {
        System.out.println("Đang lưu dữ liệu vào file...");
        throw new IOException("Không thể ghi file!");
    }

    public static void processUserData() throws IOException {
        System.out.println("Đang xử lý dữ liệu người dùng...");
        saveToFile();
    }
}
