package com.example.antiq.repository;

import com.example.antiq.entity.Author;
import com.example.antiq.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
