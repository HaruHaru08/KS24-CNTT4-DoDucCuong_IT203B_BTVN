package session07.bai3;

public interface CardPayable extends PaymentMethod {
    void processCreditCard(double amount);
}
