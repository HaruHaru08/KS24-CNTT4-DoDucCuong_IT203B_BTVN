package session07.bai6;

import session07.bai6.PaymentMethod;

public class CODPayment implements PaymentMethod {
    public void pay(double amount){
        System.out.println("Thanh toán COD: " + amount);
    }

    public String getName(){
        return "COD";
    }
}
