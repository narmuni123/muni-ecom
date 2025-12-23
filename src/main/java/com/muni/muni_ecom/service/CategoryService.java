package com.muni.muni_ecom.service;

import com.muni.muni_ecom.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();

    void createCategory(Category category);
}
