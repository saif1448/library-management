package com.example.librarymanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.librarymanagement.models.BorrowedBy;
import com.example.librarymanagement.models.Publisher;
import com.example.librarymanagement.models.DTO.BorrowdByDto;
import com.example.librarymanagement.models.DTO.PublisherDto;
import com.example.librarymanagement.services.PublisherService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/publisher")
public class PublisherController {
    @Autowired
    PublisherService publisherService;

    @PostMapping("/create")
    public Mono<?> createPublisher(@RequestBody Publisher publihser) {
        return publisherService.savePublisher(publihser);
    }

    @GetMapping("/get-all")
    public Flux<?> getAllPublisher() {
        return publisherService.getAll();
    }

    @GetMapping("/get/{id}")
    public Mono<?> getPublisherId(@PathVariable String id) {
        return publisherService.getById(id);
    }

    @PutMapping("/update/{id}")
    public Mono<?> updatePublisherId(@PathVariable String id, @RequestBody PublisherDto publisherDto) {
        return publisherService.modifyPublisherById(id, publisherDto);

    }

    @DeleteMapping("/delete/{id}")
    public Mono<?> deletePublisherId(@PathVariable String id) {
        return publisherService.removePublisherById(id);
    }
}
