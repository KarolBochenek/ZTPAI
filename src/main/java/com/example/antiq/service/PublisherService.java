package com.example.antiq.service;

import com.example.antiq.entity.Publisher;
import com.example.antiq.repository.PublisherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {
    private PublisherRepository publisherRepository;
    public List<Publisher> getAllPublishers(){
        return publisherRepository.findAll();
    }
    public Publisher getPublisherById(int id){
        return publisherRepository.findById(id).orElseThrow(() -> new RuntimeException("Id is incorrect"));
    }
    public Publisher saveOrUpdatePublisher(Publisher publisher){
        return publisherRepository.save(publisher);
    }
    public void deletePublisherById(int id){
        publisherRepository.findById(id).orElseThrow(() -> new RuntimeException("Id is incorrect"));
        publisherRepository.deleteById(id);
    }
}
