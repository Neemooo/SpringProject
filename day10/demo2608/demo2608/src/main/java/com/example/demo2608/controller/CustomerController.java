package com.example.demo2608.controller;

import com.example.demo2608.model.Customer;
import com.example.demo2608.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    final int MAX_DISPLAY = 5;
    @Autowired
    IBaseService<Customer> service;

    // show list customer according with total record for each page that is 5 record;
    @GetMapping("")
    public ResponseEntity<Page<Customer>> findAll(@PageableDefault(size = MAX_DISPLAY, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return new ResponseEntity<>(service.findAll(pageable), HttpStatus.OK);
    }

    // show customer according to name
    @GetMapping("/findByName")
    public ResponseEntity<Page<Customer>> findByName(@RequestParam(defaultValue = "", name = "n") String name,
                                                     @PageableDefault(size = MAX_DISPLAY, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return new ResponseEntity<>(service.findByName(name, pageable), HttpStatus.OK);
    }

    // find customer according to id
    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(service.findById(id), HttpStatus.ACCEPTED);
    }

    // deleteById don't finished:
    @GetMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) throws Exception {
        service.deleteById(id);
        return ResponseEntity.ok("Customer with id " + id + " has been deleted.");
    }

    // create and update customer
    @PostMapping("/create")
    public ResponseEntity<Customer> updateOrCreate(@RequestBody Customer customer){
        return new ResponseEntity<>(service.updateOrCreate(customer),HttpStatus.OK);
    }
}
