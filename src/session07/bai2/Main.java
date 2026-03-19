package session07.bai2;

public class Main {
    public static void main(String[] args) {
        double total = 1000000;

        // Percentage 10%
        OrderCalculator percentCalc = new OrderCalculator(new PercentageDiscount(10));

        System.out.println("Đơn hàng: tổng tiền 1.000.000, áp dụng PercentageDiscount 10%");
        System.out.println("Số tiền sau giảm: " + percentCalc.calculate(total));

        // Fixed 50.000
        OrderCalculator fixedCalc = new OrderCalculator(new FixedDiscount(50000));

        System.out.println("\nĐơn hàng: tổng tiền 1.000.000, áp dụng FixedDiscount 50.000");
        System.out.println("Số tiền sau giảm: " + fixedCalc.calculate(total));

        // No discount
        OrderCalculator noDiscountCalc = new OrderCalculator(new NoDiscount());

        System.out.println("\nĐơn hàng: tổng tiền 1.000.000, áp dụng NoDiscount");
        System.out.println("Số tiền sau giảm: " + noDiscountCalc.calculate(total));

        // Holiday discount
        OrderCalculator holidayCalc = new OrderCalculator(new HolidayDiscount());

        System.out.println("\nThêm HolidayDiscount 15% (không sửa code cũ)");
        System.out.println("Số tiền sau giảm: " + holidayCalc.calculate(total));
    }
}
