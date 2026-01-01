package com.muni.muni_ecom.service.serviceimpl;

import com.muni.muni_ecom.model.Category;
import com.muni.muni_ecom.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final List<Category> categories = new ArrayList<>();
    private Long nextID = 1L;

    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public void createCategory(Category category) {
        category.setCategoryId(nextID++);
        categories.add(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        Category category = categories.stream()
                .filter(c -> categoryId.equals(c.getCategoryId()))
                .findFirst()
                .orElse(null);

        if (category == null) return "Category Not Found!";
        categories.remove(category);
        return "Category Deleted Successfully!";
    }
}

