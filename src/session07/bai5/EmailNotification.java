package session07.bai5;

public class EmailNotification implements NotificationService {
    public void send(String message, String recipient){
        System.out.println("Gửi email: " + message);
    }
}
