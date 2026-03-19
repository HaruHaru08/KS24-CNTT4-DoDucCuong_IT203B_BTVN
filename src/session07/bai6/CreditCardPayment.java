package session07.bai6;

import session07.bai6.PaymentMethod;

public class CreditCardPayment implements PaymentMethod {
    public void pay(double amount){
        System.out.println("Thanh toán thẻ tín dụng: " + amount);
    }

    public String getName(){
        return "Credit Card";
    }
}
