package session07.bai5;

public class HolidayDiscount implements DiscountStrategy {
    public double applyDiscount(double total){
        return total * 0.85;
    }

    public String getName(){
        return "Holiday 15%";
    }
}
