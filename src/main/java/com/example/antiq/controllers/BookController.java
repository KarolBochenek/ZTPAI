package com.example.antiq.controllers;

import com.example.antiq.entity.Author;
import com.example.antiq.entity.Book;
import com.example.antiq.entity.Category;
import com.example.antiq.entity.Publisher;
import com.example.antiq.service.AuthorService;
import com.example.antiq.service.BookService;
import com.example.antiq.service.CategoryService;
import com.example.antiq.service.PublisherService;
import lombok.AllArgsConstructor;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@Tag(name = "Book Management", description = "APIs for managing books")
@RestController
@AllArgsConstructor
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;
    private final CategoryService categoryService;
    private final PublisherService publisherService;

    @Operation(summary = "Get all books", description = "Fetch a list of all books in the database")
    @GetMapping
    public ResponseEntity<List<Book>> getAllAuthors() {
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @Operation(summary = "Get a book by ID", description = "Fetch a specific book by its ID from the database")
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable int id) {
        Book book = bookService.getBookById(id);
        if(book == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book);
    }

    @Operation(summary = "Create a new book", description = "Save a new book to the database along with its associated authors, publishers, and categories")
    @PostMapping
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        List<Author> authors = new ArrayList<Author>();
        for (Author author : book.getAuthors()) {
            Author foundAuthor = authorService.getAuthorById(author.getId());
            if(foundAuthor == null){
                return ResponseEntity.notFound().build();
            }
            authors.add(author);
        }
        book.setAuthors(authors);

        List<Publisher> publishers = new ArrayList<Publisher>();
        for (Publisher publisher : book.getPublishers()) {
            Publisher foundPublisher = publisherService.getPublisherById(publisher.getId());
            if(foundPublisher == null){
                return ResponseEntity.notFound().build();
            }
            publishers.add(publisher);
        }
        book.setPublishers(publishers);

        List<Category> categories = new ArrayList<Category>();
        for (Category category : book.getCategories()) {
            Category foundCategory = categoryService.getCategoryById(category.getId());
            if(foundCategory == null){
                return ResponseEntity.notFound().build();
            }
            categories.add(category);
        }
        book.setCategories(categories);

        Book createdBook = bookService.saveOrUpdateBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
    }

    @Operation(summary = "Update a book", description = "Update an existing book's details by its ID, including authors, publishers, and categories")
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book book) {
        Book foundBook = bookService.getBookById(id);
        if(foundBook == null) {
            return ResponseEntity.notFound().build();
        }
        book.setId(id);
        bookService.saveOrUpdateBook(book);
        return ResponseEntity.ok(foundBook);
    }

    @Operation(summary = "Delete a book", description = "Remove a book from the database by its ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable int id) {
        Book book = bookService.getBookById(id);
        if(book == null) {
            return ResponseEntity.notFound().build();
        }
        bookService.deleteBookById(id);
        return ResponseEntity.noContent().build();
    }
}
