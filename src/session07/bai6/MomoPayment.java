package session07.bai6;

import session07.bai6.PaymentMethod;

public class MomoPayment implements PaymentMethod {
    public void pay(double amount){
        System.out.println("Thanh toán MoMo: " + amount);
    }

    public String getName(){
        return "MoMo";
    }
}
