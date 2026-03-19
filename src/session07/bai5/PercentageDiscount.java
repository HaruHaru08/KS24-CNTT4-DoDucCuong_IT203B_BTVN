package session07.bai5;

public class PercentageDiscount implements DiscountStrategy {
    private double percent;

    public PercentageDiscount(double percent){
        this.percent = percent;
    }

    public double applyDiscount(double total){
        return total * (1 - percent/100);
    }

    public String getName(){
        return percent + "%";
    }
}
