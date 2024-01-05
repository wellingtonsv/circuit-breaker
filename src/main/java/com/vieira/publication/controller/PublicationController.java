package com.vieira.publication.controller;

import com.vieira.publication.controller.request.PublicationRequest;
import com.vieira.publication.domain.Publication;
import com.vieira.publication.mapper.PublicationMapper;
import com.vieira.publication.service.PublicationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/publications")
public class PublicationController {

    @Autowired
    private PublicationService service;

    @Autowired
    private PublicationMapper publicationMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void insert(@Valid @RequestBody PublicationRequest publicationRequest){
        var publication = publicationMapper.toPublication(publicationRequest);
        service.insert(publication);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Publication> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Publication findById (@PathVariable("id") String id){
       return service.findById(id);
    }
}
