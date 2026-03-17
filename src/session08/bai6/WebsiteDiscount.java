package session08.bai6;

public class WebsiteDiscount implements DiscountStrategy {
    public double applyDiscount(double amount) {
        double discount = amount * 0.10;
        System.out.println("Áp dụng giảm giá 10%: " + discount);
        return amount - discount;
    }
}
