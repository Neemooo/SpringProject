package com.example.demo2608.controller;


import com.example.demo2608.model.Service;
import com.example.demo2608.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/service")
public class ServiceController {
    @Autowired
    IServiceService<Service> service;

    // List service
    @GetMapping("")
    public ResponseEntity<List<Service>> findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    // delete according to id
    @GetMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) throws Exception {
        service.deleteById(id);
        return new  ResponseEntity<>("Service with id " + id + " has been deleted.", HttpStatus.OK);
    }

    // show service according to id
    @GetMapping("/{id}")
    public ResponseEntity<Service> findById(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(service.findById(id), HttpStatus.ACCEPTED);
    }

}
