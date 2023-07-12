package com.dgv.ims.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dgv.ims.dto.ProductDto;
import com.dgv.ims.entity.Product;
import com.dgv.ims.service.ProductService;

@RestController
@RequestMapping("ims/products")
@CrossOrigin("*")
public class ProductController {

	private final ProductService productService;
	
	 @Autowired
	    public ProductController(ProductService productService) {
	        this.productService = productService;
	    }

	    @PostMapping
	    public ResponseEntity<Product> addProduct(@RequestBody ProductDto productDto) {
	        Product createdProduct = productService.addProduct(productDto);
	        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
	    }

	    @DeleteMapping("/{productId}")
	    public ResponseEntity<Void> removeProduct(@PathVariable Long productId) {
	        productService.removeProduct(productId);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }

	    @GetMapping("/{productId}")
	    public ResponseEntity<Product> getProductById(@PathVariable Long productId) {
	        Product product = productService.getProductById(productId);
	        return new ResponseEntity<>(product, HttpStatus.OK);
	    }

	    @GetMapping
	    public ResponseEntity<List<Product>> getAllProducts() {
	        List<Product> products = productService.getAllProducts();
	        return new ResponseEntity<>(products, HttpStatus.OK);
	    }

	    @PostMapping("/{productId}/refill/{quantity}")
	    public ResponseEntity<Void> refillProduct(@PathVariable Long productId, @PathVariable Integer quantity) {
	        productService.refillProduct(productId, quantity);
	        return new ResponseEntity<>(HttpStatus.OK);
	    }
}
