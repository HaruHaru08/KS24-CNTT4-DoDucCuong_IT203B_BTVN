package session07.bai6;

import session07.bai6.NotificationService;

public class EmailNotification implements NotificationService {
    public void send(String message, String recipient){
        System.out.println("Gửi email: " + message);
    }
}
