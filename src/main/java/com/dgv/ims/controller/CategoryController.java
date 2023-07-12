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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dgv.ims.entity.Category;
import com.dgv.ims.service.CategoryService;

@RestController
@RequestMapping("/ims/categories")
@CrossOrigin("*")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;


	    @PostMapping
	    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
	        Category createdCategory = categoryService.createCategory(category);
	        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
	    }

	    @PutMapping("/{categoryId}")
	    public ResponseEntity<Category> updateCategory(@PathVariable Long categoryId, @RequestBody Category category) {
	        category.setId(categoryId);
	        Category updatedCategory = categoryService.updateCategory(category);
	        return ResponseEntity.ok(updatedCategory);
	    }

	    @DeleteMapping("/{categoryId}")
	    public ResponseEntity<Void> deleteCategory(@PathVariable Long categoryId) {
	        categoryService.deleteCategory(categoryId);
	        return ResponseEntity.noContent().build();
	    }

	    @GetMapping("/{categoryId}")
	    public ResponseEntity<Category> getCategoryById(@PathVariable Long categoryId) {
	        Category category = categoryService.getCategoryById(categoryId);
	        return ResponseEntity.ok(category);
	    }

	    @GetMapping
	    public ResponseEntity<List<Category>> getAllCategories() {
	        List<Category> categories = categoryService.getAllCategories();
	        return ResponseEntity.ok(categories);
	    }

}
