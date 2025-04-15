package qldh.entity;

import java.time.LocalDate;
import java.util.List;

public class Order {
    private int id;
    private int customerId;
    private LocalDate orderDate;
    private List<OrderItem> items;

    public Order() {}

    public Order(int customerId, LocalDate orderDate, List<OrderItem> items) {
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.items = items;
    }

    public Order(int id, int customerId, LocalDate orderDate) {
        this.id = id;
        this.customerId = customerId;
        this.orderDate = orderDate;
    }


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }

    public LocalDate getOrderDate() { return orderDate; }
    public void setOrderDate(LocalDate orderDate) { this.orderDate = orderDate; }

    public List<OrderItem> getItems() { return items; }
    public void setItems(List<OrderItem> items) { this.items = items; }
}
