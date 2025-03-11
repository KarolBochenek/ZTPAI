package com.example.antiq.service;

import com.example.antiq.entity.Category;
import com.example.antiq.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;
    public List<Category> getAllCategorys(){
        return categoryRepository.findAll();
    }
    public Category getCategoryById(int id){
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Id is incorrect"));
    }
    public Category saveOrUpdateCategory(Category category){
        return categoryRepository.save(category);
    }
    public void deleteCategoryById(int id){
        categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Id is incorrect"));
        categoryRepository.deleteById(id);
    }
}
