package session07.bai6;

public interface SalesChannelFactory {
    DiscountStrategy createDiscount();

    PaymentMethod createPayment();

    NotificationService createNotification();

    String getChannelName();
}
