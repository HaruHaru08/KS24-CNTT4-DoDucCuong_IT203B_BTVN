package session07.bai3;

public class PaymentProcessor {
    public void process(PaymentMethod method, double amount) {
        if (method instanceof CODPayable cod) {
            cod.processCOD(amount);
        }

        else if (method instanceof CardPayable card) {
            card.processCreditCard(amount);
        }

        else if (method instanceof EWalletPayable wallet) {
            wallet.processMomo(amount);
        }

        else {
            System.out.println("Phương thức thanh toán không hỗ trợ");
        }
    }
}
