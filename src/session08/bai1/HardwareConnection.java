package session08.bai1;

public class HardwareConnection {
    private static HardwareConnection instance;

    private HardwareConnection() {
        // Private constructor
    }

    public static synchronized HardwareConnection getInstance() {
        if (instance == null) {
            instance = new HardwareConnection();
            System.out.println("HardwareConnection: Đã kết nối phần cứng.");
        }
        return instance;
    }

    public void connect() {
        // Already handled in getInstance for the "first time" message as per requirement implication,
        // but explicit call might be needed if the user wants to trigger it explicitly.
        // However, the requirement says "Chỉ hiện 1 lần duy nhất" for "Đã kết nối phần cứng" when creating the instance.
        // Let's stick to the requirement: "Lớp này có phương thức connect() và disconnect() (chỉ in ra console)."
        // But also "Kết nối phần cứng (lấy instance Singleton)." and output example shows "HardwareConnection: Đã kết nối phần cứng. (Chỉ hiện 1 lần duy nhất)".
        // Usually, this message comes from the constructor or the first initialization.
    }

    public void disconnect() {
        System.out.println("HardwareConnection: Đã ngắt kết nối phần cứng.");
    }
}
