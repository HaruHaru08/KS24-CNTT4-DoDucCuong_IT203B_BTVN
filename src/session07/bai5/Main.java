package session07.bai5;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Product> products = new ArrayList<>();
        List<Customer> customers = new ArrayList<>();
        List<DiscountStrategy> discounts = new ArrayList<>();
        List<PaymentMethod> payments = new ArrayList<>();

        OrderRepository repository = new FileOrderRepository();
        NotificationService notification = new EmailNotification();

        OrderService orderService = new OrderService(repository, notification);

        InvoiceGenerator invoice = new InvoiceGenerator();

        // discount mặc định
        discounts.add(new PercentageDiscount(10));
        discounts.add(new FixedDiscount(50000));
        discounts.add(new HolidayDiscount());

        // payment mặc định
        payments.add(new CODPayment());
        payments.add(new CreditCardPayment());
        payments.add(new MomoPayment());
        payments.add(new VNPayPayment());

        while(true){

            System.out.println("\n===== MENU =====");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Thêm khách hàng");
            System.out.println("3. Tạo đơn hàng");
            System.out.println("4. Xem đơn hàng");
            System.out.println("5. Tính doanh thu");
            System.out.println("6. Thêm phương thức thanh toán");
            System.out.println("7. Thêm chiến lược giảm giá");
            System.out.println("0. Thoát");
            System.out.print("Lựa chọn chức năng: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if(choice == 0){
                break;
            }

            switch(choice){
                case 1:
                    System.out.print("Mã: ");
                    String id = sc.nextLine();

                    System.out.print("Tên: ");
                    String name = sc.nextLine();

                    System.out.print("Giá: ");
                    double price = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Danh mục: ");
                    String category = sc.nextLine();

                    products.add(new Product(id,name,price,category));

                    System.out.println("Đã thêm sản phẩm " + id);

                    break;
                case 2:
                    System.out.print("Tên: ");
                    String cname = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("ĐT: ");
                    String phone = sc.nextLine();

                    customers.add(new Customer(cname,email,phone));

                    System.out.println("Đã thêm khách hàng");

                    break;
                case 3:
                    if(products.isEmpty() || customers.isEmpty()){
                        System.out.println("Cần có sản phẩm và khách hàng trước");
                        break;
                    }

                    System.out.println("Chọn khách hàng");

                    for(int i=0;i<customers.size();i++){
                        System.out.println(i + ". " + customers.get(i).getName());
                    }

                    int cIndex = sc.nextInt();
                    Customer customer = customers.get(cIndex);

                    List<OrderItem> items = new ArrayList<>();

                    System.out.println("Chọn sản phẩm");

                    for(int i=0;i<products.size();i++){
                        System.out.println(i + ". " + products.get(i).getName());
                    }

                    int pIndex = sc.nextInt();

                    System.out.print("Số lượng: ");
                    int qty = sc.nextInt();

                    items.add(new OrderItem(products.get(pIndex),qty));

                    Order order = new Order("ORD" + (orderService.getOrders().size()+1), customer, items);

                    System.out.println("Chọn giảm giá");

                    for(int i=0;i<discounts.size();i++){
                        System.out.println(i + ". " + discounts.get(i).getName());
                    }

                    int dIndex = sc.nextInt();

                    System.out.println("Chọn thanh toán");

                    for(int i=0;i<payments.size();i++){
                        System.out.println(i + ". " + payments.get(i).getName());
                    }

                    int payIndex = sc.nextInt();

                    DiscountStrategy discount = discounts.get(dIndex);
                    PaymentMethod payment = payments.get(payIndex);

                    orderService.createOrder(order,discount,payment);

                    invoice.printInvoice(order);

                    break;
                case 4:
                    List<Order> orders = orderService.getOrders();

                    System.out.println("Danh sách đơn hàng");

                    for(Order o : orders){
                        System.out.println(
                                o.getId() + " - " +
                                        o.getCustomer().getName() +
                                        " - " +
                                        o.getFinalAmount()
                        );
                    }
                    break;
                case 5:
                    double revenue = 0;

                    for(Order o : orderService.getOrders()){
                        revenue += o.getFinalAmount();
                    }

                    System.out.println("Tổng doanh thu: " + revenue);
                    break;
                case 6:
                    sc.nextLine();
                    System.out.print("Tên phương thức thanh toán mới: ");
                    String newPay = sc.nextLine();

                    payments.add(new PaymentMethod() {

                        public void pay(double amount){
                            System.out.println("Thanh toán " + newPay + ": " + amount);
                        }

                        public String getName(){
                            return newPay;
                        }
                    });

                    System.out.println("Đã thêm phương thức thanh toán " + newPay);
                    break;
                case 7:
                    System.out.print("Nhập % giảm giá mới: ");
                    double percent = sc.nextDouble();

                    discounts.add(new PercentageDiscount(percent));

                    System.out.println("Đã thêm chiến lược giảm giá " + percent + "%");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }

        }
        System.out.println("Thoát chương trình");
    }
}
