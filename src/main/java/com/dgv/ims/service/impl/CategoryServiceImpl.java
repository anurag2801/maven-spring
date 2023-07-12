package com.dgv.ims.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgv.ims.entity.Category;
import com.dgv.ims.exception.ResourceNotFoundException;
import com.dgv.ims.repository.CategoryRepository;
import com.dgv.ims.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	
	@Autowired
    private CategoryRepository categoryRepo;

    @Override
    public Category createCategory(Category category) {
        return categoryRepo.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        // Check if category exists
        Category existingCategory = categoryRepo.findById(category.getId())

                .orElseThrow(() -> new ResourceNotFoundException("Category nahi mili "));


        // Update the category properties
        existingCategory.setName(category.getName());
        existingCategory.setDescription(category.getDescription());

        return categoryRepo.save(existingCategory);
    }

    @Override
    public void deleteCategory(Long categoryId) {
        // Check if category exists
        Category existingCategory = categoryRepo.findById(categoryId)

                .orElseThrow(() -> new ResourceNotFoundException("Category nahi mili"));


        categoryRepo.delete(existingCategory);
    }

    @Override
    public Category getCategoryById(Long categoryId) {
        return categoryRepo.findById(categoryId)

                .orElseThrow(() -> new ResourceNotFoundException("Category nahi mili"));

    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }
}
