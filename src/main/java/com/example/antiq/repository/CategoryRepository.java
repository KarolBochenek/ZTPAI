package com.example.antiq.repository;

import com.example.antiq.entity.Author;
import com.example.antiq.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
