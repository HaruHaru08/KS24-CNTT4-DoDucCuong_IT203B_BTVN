package session07.bai6;

public class PushNotification implements NotificationService {
    public void send(String message, String recipient) {
        System.out.println("Gửi push notification: " + message);
    }
}
