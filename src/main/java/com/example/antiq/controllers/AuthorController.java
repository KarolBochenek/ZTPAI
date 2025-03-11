package com.example.antiq.controllers;

import com.example.antiq.entity.Author;
import com.example.antiq.service.AuthorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "Author Management", description = "APIs for managing authors")
@RestController
@AllArgsConstructor
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorService authorService;

    @Operation(summary = "Get all authors", description = "Retrieve a list of all authors")
    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthors() {
        List<Author> authors = authorService.getAllAuthors();
        return ResponseEntity.ok(authors);
    }
    @Operation(summary = "Get author by Id", description = "Retrieve information about an author")
    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthor(@PathVariable int id) {
        Author author = authorService.getAuthorById(id);
        if (author == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(author);
    }
    @Operation(summary = "Create a new author", description = "Save a new author to the database")
    @PostMapping
    public ResponseEntity<Author> saveAuthor(@RequestBody Author author) {
        Author createdAuthor = authorService.saveOrUpdateAuthor(author);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAuthor);
    }
    @Operation(summary = "Update an author", description = "Update an existing author by its ID")
    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable int id, @RequestBody Author author) {
        Author foundAuthor = authorService.getAuthorById(id);
        if (foundAuthor == null) {
            return ResponseEntity.notFound().build();
        }
        author.setId(id);
        authorService.saveOrUpdateAuthor(author);
        return ResponseEntity.ok(author);

    }
    @Operation(summary = "Delete an author", description = "Remove an author from the database by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable int id) {
        Author author = authorService.getAuthorById(id);
        if (author == null) {
            return ResponseEntity.notFound().build();
        }
        authorService.deleteAuthorById(id);
        return ResponseEntity.noContent().build();
    }
}
