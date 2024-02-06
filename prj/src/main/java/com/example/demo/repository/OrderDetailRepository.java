package com.example.demo.repository;

import com.example.demo.domain.entity.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDetailRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public OrderDetailRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addOrderDetail(OrderDetail orderDetail) {
        String sql = "INSERT INTO order_details (order_detail_id, order_id, product_id, quantity, unit_price) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(
                sql,
                orderDetail.getOrderDetailId(),
                orderDetail.getOrderId(),
                orderDetail.getProductId(),
                orderDetail.getQuantity(),
                orderDetail.getUnitPrice()
        );
    }



    public List<OrderDetail> getAllOrderDetails() {
        String sql = "SELECT * FROM order_details";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(OrderDetail.class));
    }
}

