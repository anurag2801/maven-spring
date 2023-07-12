package com.dgv.ims.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dgv.ims.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
