package com.dgv.ims.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dgv.ims.dto.OrderDto;
import com.dgv.ims.entity.Order;
import com.dgv.ims.service.OrderService;

@RestController
@RequestMapping("ims/orders")
@CrossOrigin("*")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order placeOrder(@RequestBody OrderDto orderDto) {
        return orderService.placeOrder(orderDto);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }
    
    @GetMapping("/reports")
    public List<Map<String, Double>> generateRevenueReports() {
        return orderService.generateRevenueReports();
    }

    @GetMapping("/total")
    public double getTotalRevenue() {
        return orderService.getTotalRevenue();
    }

}
