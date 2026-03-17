package session08.bai6;

public class MomoPayment implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Xử lý thanh toán MoMo: " + amount);
    }
}
