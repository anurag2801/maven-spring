package com.dgv.ims.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dgv.ims.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

	@Query(value = "SELECT p.name as product, SUM(o.total_amount) as totalRevenue FROM anurag_ims_product p JOIN anurag_ims_order o ON p.id = o.product_id GROUP BY p.name", nativeQuery = true)
	List<Map<String, Double>> generateRevenueReports();

	@Query(value = "SELECT SUM(o.total_amount) FROM anurag_ims_order o", nativeQuery = true)
	double getTotalRevenue();

}
