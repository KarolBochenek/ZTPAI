package com.example.antiq.service;

import com.example.antiq.entity.Book;
import com.example.antiq.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private BookRepository bookRepository;
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
    public Book getBookById(int id){
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Id is incorrect"));
    }
    public Book saveOrUpdateBook(Book book){
        return bookRepository.save(book);
    }
    public void deleteBookById(int id){
        bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Id is incorrect"));
        bookRepository.deleteById(id);
    }
}
