package session07.bai6;

public class MobileAppFactory implements SalesChannelFactory {
    public DiscountStrategy createDiscount() {
        return new PercentageDiscount(15);
    }

    public PaymentMethod createPayment() {
        return new MomoPayment();
    }

    public NotificationService createNotification() {
        return new PushNotification();
    }

    public String getChannelName() {
        return "Mobile App";
    }
}
