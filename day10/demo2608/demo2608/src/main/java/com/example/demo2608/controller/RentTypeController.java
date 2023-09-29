package com.example.demo2608.controller;

import com.example.demo2608.model.type.Rent_type;
import com.example.demo2608.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rentType")
public class RentTypeController {
    @Autowired
    IServiceService<Rent_type> service;

    // List rent_type
    @GetMapping("")
    public ResponseEntity<List<Rent_type>> findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    // show rent_type according to id
    @GetMapping("/{id}")
    public ResponseEntity<Rent_type> findById(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(service.findById(id), HttpStatus.ACCEPTED);
    }

    // create and update rent_type
    @PostMapping("/create/{id}")
    public ResponseEntity<Rent_type> save(@RequestBody Rent_type type) throws Exception {
        return new ResponseEntity<>(service.save(type), HttpStatus.OK);
    }

    // delete according to id
    @GetMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) throws Exception {
         service.deleteById(id);
         return ResponseEntity.ok("RentType with id " + id + " has been deleted.");
    }
}
