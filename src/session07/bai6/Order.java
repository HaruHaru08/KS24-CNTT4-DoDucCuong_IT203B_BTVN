package session07.bai6;

import session07.bai6.Customer;

import java.util.List;

public class Order {
    private String id;
    private Customer customer;
    private List<OrderItem> items;
    private double finalAmount;

    public Order(String id, Customer customer, List<OrderItem> items){
        this.id = id;
        this.customer = customer;
        this.items = items;
    }

    public String getId(){ return id; }
    public Customer getCustomer(){ return customer; }
    public List<OrderItem> getItems(){ return items; }

    public double getFinalAmount(){ return finalAmount; }
    public void setFinalAmount(double amount){ this.finalAmount = amount; }
}
