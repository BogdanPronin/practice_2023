package com.example.demo.repository;
import com.example.demo.domain.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public OrderRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addOrder(Order order) {
        String sql = "INSERT INTO orders (order_id, user_id, order_date, order_status) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(
                sql,
                order.getOrderId(),
                order.getUserId(),
                order.getOrderDate(),
                order.getOrderStatus()
        );
    }
    public List<Order> getAllOrders() {
        String sql = "SELECT * FROM orders";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Order.class));
    }
}


