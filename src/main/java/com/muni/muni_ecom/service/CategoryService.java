package com.muni.muni_ecom.service;

import com.muni.muni_ecom.model.Category;
import com.muni.muni_ecom.payload.CategoryDTO;
import com.muni.muni_ecom.payload.CategoryResponse;

import java.util.List;

public interface CategoryService {

    CategoryResponse getAllCategories();

    void createCategory(Category category);

    String deleteCategory(Long categoryId);

    String updateCategory(Long categoryId, Category updateCategory);
}
