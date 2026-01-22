package com.muni.muni_ecom.service.serviceimpl;

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
        return categoryRepository.findAll();
    }

    @Override
    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {

        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found."));
        categoryRepository.delete(category);
        return "Category with id: " + categoryId + " deleted successfully!";
    }

    @Override
    public String updateCategory(Long categoryId, Category updatedCategory) {

        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found."));

        category.setCategoryName(updatedCategory.getCategoryName());

        categoryRepository.save(category);
        return "Category with id: " + categoryId + " updated successfully!";
    }
}

