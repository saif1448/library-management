package com.example.librarymanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.librarymanagement.models.Publisher;
import com.example.librarymanagement.models.DTO.PublisherDto;
import com.example.librarymanagement.repositories.PublisherRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PublisherService {
    @Autowired
    PublisherRepository publisherRepository;

    public Mono<?> savePublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    public Flux<?> getAll() {
        return publisherRepository.findAll();
    }

    public Mono<?> getById(String id) {
        return publisherRepository.findById(id);
    }

    public Mono<?> modifyPublisherById(String id, PublisherDto publisherDto) {
        return publisherRepository.findById(id)
                // .switchIfEmpty(Mono.error(new Throwable("Book not found for id: " + id)))
                .flatMap(publihser -> {
                    if (publihser != null) {
                        if (publisherDto.getName() != null) {
                            publihser.setName(publisherDto.getName());
                        }
                        if (publisherDto.getAddress() != null) {
                            publihser.setAddress(publisherDto.getAddress());
                        }
                        return publisherRepository.save(publihser);
                    } else {
                        return getById(id);
                    }

                });
    }

    public Mono<?> removePublisherById(String id) {

        return publisherRepository.deleteById(id);

    }

}
