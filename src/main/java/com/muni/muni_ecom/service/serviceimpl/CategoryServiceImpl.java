package com.muni.muni_ecom.service.serviceimpl;

import com.muni.muni_ecom.exception.ApiException;
import com.muni.muni_ecom.exception.EmptyResourceException;
import com.muni.muni_ecom.exception.ResourceNotFoundException;
import com.muni.muni_ecom.model.Category;
import com.muni.muni_ecom.repository.CategoryRepository;
import com.muni.muni_ecom.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {


    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        List<Category> savedCategories = categoryRepository.findAll();
        if(savedCategories.isEmpty()) throw new EmptyResourceException("No categories exist.");
        return savedCategories;
    }

    @Override
    public void createCategory(Category category) {
        Category savedCategory = categoryRepository.findByCategoryName(category.getCategoryName());
        if(savedCategory != null) throw new ApiException("Category with the name " + category.getCategoryName() + " already exists.");
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));
        categoryRepository.delete(category);
        return "Category with id: " + categoryId + " deleted successfully!";
    }

    @Override
    public String updateCategory(Long categoryId, Category updatedCategory) {

        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));

        category.setCategoryName(updatedCategory.getCategoryName());
        categoryRepository.save(category);
        return "Category with id: " + categoryId + " updated successfully!";
    }
}

