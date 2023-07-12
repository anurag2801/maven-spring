package com.dgv.ims.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgv.ims.exception.ResourceNotFoundException;
import com.dgv.ims.dto.ProductDto;
import com.dgv.ims.entity.Category;
import com.dgv.ims.entity.Product;
import com.dgv.ims.repository.CategoryRepository;
import com.dgv.ims.repository.ProductRepository;
import com.dgv.ims.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
    private ProductRepository productRepo;
	
	@Autowired
	private CategoryRepository categoryRepo;

	@Override
	public Product addProduct(ProductDto productDto) {
		Product product = new Product();
		System.out.println("product info = "+productDto.getCategoryId());
    	Category category = categoryRepo.findById(productDto.getCategoryId()).orElseThrow(()-> new ResourceNotFoundException("user not found"));
    	product.setDescription(productDto.getDescription());
    	product.setName(productDto.getName());
    	product.setQuantity(productDto.getQuantity());
    	product.setPrice(productDto.getPrice());
    	product.setCategory(category);
    	product = productRepo.save(product);
        return product;
	}

	@Override
	public void removeProduct(Long productId) {
		Product existingProduct = productRepo.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        productRepo.delete(existingProduct);
		
	}

	@Override
	public Product getProductById(Long productId) {
		return productRepo.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

	@Override
	public void refillProduct(Long productId, Integer quantity) {
		 Product product = getProductById(productId);
	        Integer currentQuantity = product.getQuantity();
	        product.setQuantity(currentQuantity + quantity);
	        productRepo.save(product);
		
	}
	
	

}
