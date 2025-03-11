package com.example.antiq.service;

import com.example.antiq.entity.Category;
import com.example.antiq.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    public List<Category> getAllCategories(){
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
