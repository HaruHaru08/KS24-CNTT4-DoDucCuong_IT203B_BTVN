package session07.bai6;

public class PrintReceiptNotification implements NotificationService {
    public void send(String message, String recipient) {
        System.out.println("In hóa đơn giấy: " + message);
    }
}
