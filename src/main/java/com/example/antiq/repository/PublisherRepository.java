package com.example.antiq.repository;

import com.example.antiq.entity.Author;
import com.example.antiq.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
}
