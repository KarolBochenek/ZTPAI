package com.example.antiq.service;

import com.example.antiq.entity.Author;
import com.example.antiq.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class AuthorService {
    private final AuthorRepository authorRepository;
    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }
    public Author getAuthorById(int id){
        return authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Id is incorrect"));
    }
    public Author saveOrUpdateAuthor(Author author){
        return authorRepository.save(author);
    }
    public void deleteAuthorById(int id){
        authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Id is incorrect"));
        authorRepository.deleteById(id);
    }
}
