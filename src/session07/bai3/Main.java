package session07.bai3;

public class Main {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();
        PaymentMethod cod = new CODPayment();
        PaymentMethod card = new CreditCardPayment();
        PaymentMethod momo = new MomoPayment();

        System.out.println("COD");
        processor.process(cod, 500000);

        System.out.println("\nThẻ tín dụng");
        processor.process(card, 1000000);

        System.out.println("\nVí MoMo");
        processor.process(momo, 750000);

        System.out.println("\nKiểm tra LSP");
        PaymentMethod anotherPayment = new MomoPayment();
        processor.process(anotherPayment, 1000000);
    }
}
