package qldh.dao;

import qldh.entity.Order;
import qldh.entity.OrderItem;
import qldh.util.DBUtil;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {

    public void createOrder(Order order, List<OrderItem> items) {
        try (Connection conn = DBUtil.getConnection()) {
            conn.setAutoCommit(false);
            String insertOrder = "INSERT INTO orders (customer_id, order_date) VALUES (?, ?)";
            PreparedStatement orderStmt = conn.prepareStatement(insertOrder, Statement.RETURN_GENERATED_KEYS);
            orderStmt.setInt(1, order.getCustomerId());
            orderStmt.setDate(2, Date.valueOf(order.getOrderDate()));
            orderStmt.executeUpdate();

            ResultSet rs = orderStmt.getGeneratedKeys();
            int orderId = 0;
            if (rs.next()) {
                orderId = rs.getInt(1);
            }

            String insertItem = "INSERT INTO order_items (order_id, product_id, quantity) VALUES (?, ?, ?)";
            PreparedStatement itemStmt = conn.prepareStatement(insertItem);

            for (OrderItem item : items) {
                itemStmt.setInt(1, orderId);
                itemStmt.setInt(2, item.getProductId());
                itemStmt.setInt(3, item.getQuantity());
                itemStmt.addBatch();
            }

            itemStmt.executeBatch();
            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Order> getOrdersByCustomerId(int customerId) {
        List<Order> orders = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection()) {
            String sql = "SELECT * FROM orders WHERE customer_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, customerId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                orders.add(new Order(
                        rs.getInt("order_id"),
                        rs.getInt("customer_id"),
                        rs.getDate("order_date").toLocalDate()
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    public double calculateTotalAmount(int orderId) {
        double total = 0;
        try (Connection conn = DBUtil.getConnection()) {
            String sql = """
                SELECT SUM(p.price * oi.quantity) AS total
                FROM order_items oi
                JOIN products p ON oi.product_id = p.product_id
                WHERE oi.order_id = ?
            """;
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, orderId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                total = rs.getDouble("total");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }
}
