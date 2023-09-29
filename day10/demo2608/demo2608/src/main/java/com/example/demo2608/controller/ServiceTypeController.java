package com.example.demo2608.controller;

import com.example.demo2608.model.type.Service_type;
import com.example.demo2608.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/serviceType")
public class ServiceTypeController {
    @Autowired
    IServiceService<Service_type> service;

    // show list service_type:
    @GetMapping("")
    public ResponseEntity<List<Service_type>> findAll(){
       return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    // find service_type according to id:
    @GetMapping("/{id}")
    public ResponseEntity<Service_type> findById(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    //delete according to id
    @GetMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) throws Exception {
        service.deleteById(id);
        return ResponseEntity.ok("ServiceType with id " + id + " has been deleted.");
    //        return new ResponseEntity<>("ServiceType with id " + id + " has been deleted.", HttpStatus.OK);
    }

    //function both 2 mission: create and update
    @PostMapping("/create")
    public ResponseEntity<Service_type> save(@RequestBody Service_type type){
        return new ResponseEntity<>(service.save(type), HttpStatus.OK);
    }

}
