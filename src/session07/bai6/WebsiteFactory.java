package session07.bai6;

public class WebsiteFactory implements SalesChannelFactory {
    public DiscountStrategy createDiscount() {
        return new PercentageDiscount(10);
    }

    public PaymentMethod createPayment() {
        return new CreditCardPayment();
    }

    public NotificationService createNotification() {
        return new EmailNotification();
    }

    public String getChannelName() {
        return "Website";
    }
}
