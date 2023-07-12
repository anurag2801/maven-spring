package com.dgv.ims.service;

import java.util.List;

import com.dgv.ims.dto.ProductDto;
import com.dgv.ims.entity.Product;

public interface ProductService {
	
	   Product addProduct(ProductDto productDto);
	    
	    void removeProduct(Long productId);
	    
	    Product getProductById(Long productId);
	    
	    List<Product> getAllProducts();
	    
	    void refillProduct(Long productId, Integer quantity);

}
