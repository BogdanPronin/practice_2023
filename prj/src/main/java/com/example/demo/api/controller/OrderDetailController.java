package com.example.demo.api.controller;

import com.example.demo.domain.entity.OrderDetail;
import com.example.demo.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-details")
public class OrderDetailController {

    private final OrderDetailRepository orderDetailRepository;

    @Autowired
    public OrderDetailController(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    @PostMapping
    public ResponseEntity<String> addOrderDetail(@RequestBody OrderDetail orderDetail) {
        orderDetailRepository.addOrderDetail(orderDetail);
        return new ResponseEntity<>("Order detail added successfully!", HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<OrderDetail>> getAllOrderDetails() {
        List<OrderDetail> orderDetails = orderDetailRepository.getAllOrderDetails();
        if (!orderDetails.isEmpty()) {
            return new ResponseEntity<>(orderDetails, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

