package com.example.antiq.controllers;

import com.example.antiq.entity.Publisher;
import com.example.antiq.service.PublisherService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "Publisher Management", description = "APIs for managing publishers")
@RestController
@AllArgsConstructor
@RequestMapping("/api/publishers")
public class PublisherController {

    private final PublisherService publisherService;

    @Operation(summary = "Get all publishers", description = "Fetch a list of all publishers")
    @GetMapping
    public ResponseEntity<List<Publisher>> getAllPublishers() {
        List<Publisher> publishers = publisherService.getAllPublishers();
        return ResponseEntity.ok(publishers);
    }

    @Operation(summary = "Get a publisher by ID", description = "Fetch a specific publisher by its ID")
    @GetMapping("/{id}")
    public ResponseEntity<Publisher> getPublisher(@PathVariable int id) {
        Publisher publisher = publisherService.getPublisherById(id);
        if (publisher == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(publisher);
    }

    @Operation(summary = "Create a new publisher", description = "Save a new publisher to the database")
    @PostMapping
    public ResponseEntity<Publisher> savePublisher(@RequestBody Publisher publisher) {
        Publisher createdPublisher = publisherService.saveOrUpdatePublisher(publisher);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPublisher);
    }

    @Operation(summary = "Update a publisher", description = "Update an existing publisher by its ID")
    @PutMapping("/{id}")
    public ResponseEntity<Publisher> updatePublisher(@PathVariable int id, @RequestBody Publisher publisher) {
        Publisher foundPublisher = publisherService.getPublisherById(id);
        if (foundPublisher == null) {
            return ResponseEntity.notFound().build();
        }
        publisher.setId(id);
        publisherService.saveOrUpdatePublisher(publisher);
        return ResponseEntity.ok(publisher);
    }

    @Operation(summary = "Delete a publisher", description = "Remove a publisher from the database by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePublisher(@PathVariable int id) {
        Publisher publisher = publisherService.getPublisherById(id);
        if (publisher == null) {
            return ResponseEntity.notFound().build();
        }
        publisherService.deletePublisherById(id);
        return ResponseEntity.noContent().build();
    }
}
