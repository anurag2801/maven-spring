package com.dgv.ims.service.impl;


import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgv.ims.dto.OrderDto;
import com.dgv.ims.entity.Order;
import com.dgv.ims.entity.Product;

import com.dgv.ims.entity.User;
import com.dgv.ims.exception.ResourceNotFoundException;
import com.dgv.ims.repository.OrderRepository;
import com.dgv.ims.repository.ProductRepository;
import com.dgv.ims.repository.UserRepository;
import com.dgv.ims.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	
	
	@Autowired
	 private OrderRepository orderRepository;
	 @Autowired
	 private ProductRepository productRepository;
	 @Autowired
	 private UserRepository userRepository;
	 
	 
	@Override
	public Order placeOrder(OrderDto orderDto) {
		Order order=new Order();
 		User user = userRepository.findById(orderDto.getUserId()).orElseThrow(()-> new ResourceNotFoundException("user not found"));  
 		Product product=productRepository.findById(orderDto.getProductId()).orElseThrow(()-> new ResourceNotFoundException("user not found"));
 		order.setDate(orderDto.getDate());
 		order.setTotalAmount(orderDto.getTotalAmount());
 		order.setCustomerName(orderDto.getCustomerName());
 		order.setUser(user);
 		order.setProduct(product);
 		order.setQuantity(orderDto.getQuantity());
 		System.out.println("order info -- "+order);
 		order = orderRepository.save(order);
 		
    return order;
	}
	@Override
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}
	
	@Override
    public List<Map<String, Double>> generateRevenueReports() {
        return orderRepository.generateRevenueReports();
    }

    @Override
    public double getTotalRevenue() {
        return orderRepository.getTotalRevenue();
    }
//	@Override
//    public List<RevenueReport> generateRevenueReports() {
//        String queryStr = "SELECT p.id, p.name, SUM(o.total_amount) as totalRevenue " +
//                "FROM Product p " +
//                "JOIN Order o ON p.id = o.product.id " +
//                "GROUP BY p.id, p.name";
//
//        Query query = (Query) entityManager.createQuery(queryStr);
//        List<Object[]> results = query.getResultList();
//
//        List<RevenueReport> revenueReports = new ArrayList<>();
//        for (Object[] result : results) {
//            Long productId = (Long) result[0];
//            String productName = (String) result[1];
//            double totalRevenue = (double) result[2];
//
//            Product product = new Product();
//            product.setId(productId);
//            product.setName(productName);
//
//            RevenueReport revenueReport = new RevenueReport(product, totalRevenue);
//            revenueReports.add(revenueReport);
//        }
//
//        return revenueReports;
//    }
//
//    @Override
//    public double getTotalRevenue() {
//        String queryStr = "SELECT SUM(total_amount) FROM Order";
//        Query query = (Query) entityManager.createQuery(queryStr);
//        Double totalRevenue = (Double) query.getSingleResult();
//
//        if (totalRevenue == null) {
//            return 0.0;
//        }
//
//        return totalRevenue;
//    }
	 
} 
	 


