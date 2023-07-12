package com.dgv.ims.service;

import java.util.List;
import java.util.Map;

import com.dgv.ims.dto.OrderDto;
import com.dgv.ims.entity.Order;

public interface OrderService {
	
	Order placeOrder(OrderDto orderDto);

    List<Order> getAllOrders();

    List<Map<String, Double>> generateRevenueReports();

    double getTotalRevenue();

}
