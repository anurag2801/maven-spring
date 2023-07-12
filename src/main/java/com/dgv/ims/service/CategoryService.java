package com.dgv.ims.service;

import java.util.List;

import com.dgv.ims.entity.Category;

public interface CategoryService {
	
	Category createCategory(Category category);
    Category updateCategory(Category category);
    void deleteCategory(Long categoryId);
    Category getCategoryById(Long categoryId);
    List<Category> getAllCategories();

}
