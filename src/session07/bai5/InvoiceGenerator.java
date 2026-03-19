package session07.bai5;

public class InvoiceGenerator {
    public void printInvoice(Order order){

        double total = 0;

        System.out.println("=== HÓA ĐƠN ===");
        System.out.println("Khách: " + order.getCustomer().getName());

        for(OrderItem item : order.getItems()){

            double sub = item.getSubtotal();
            total += sub;

            System.out.println(
                    item.getProduct().getName() +
                            " - SL: " + item.getQuantity() +
                            " - Giá: " + item.getProduct().getPrice() +
                            " - Thành tiền: " + sub
            );
        }

        System.out.println("Cần thanh toán: " + order.getFinalAmount());
    }
}
