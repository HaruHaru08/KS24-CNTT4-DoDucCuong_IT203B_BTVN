package session07.bai6;

public class StorePOSFactory implements SalesChannelFactory {
    public DiscountStrategy createDiscount() {
        return new FixedDiscount(100000);
    }

    public PaymentMethod createPayment() {
        return new CODPayment();
    }

    public NotificationService createNotification() {
        return new PrintReceiptNotification();
    }

    public String getChannelName() {
        return "Store POS";
    }
}
