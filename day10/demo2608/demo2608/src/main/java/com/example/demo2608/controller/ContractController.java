package com.example.demo2608.controller;

import com.example.demo2608.model.Contract;
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
@RequestMapping("/api/contract")
public class ContractController {
    final int MAX_DISPLAY = 5;
    @Autowired
    IBaseService<Contract> service;

    // show list contract according with total record for each page that is 5 record;
    @GetMapping("")
    public ResponseEntity<Page<Contract>> findAll(@PageableDefault(size = MAX_DISPLAY, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return new ResponseEntity<>(service.findAll(pageable), HttpStatus.OK);
    }

    // show contract according to customer name:
    @GetMapping("/findByName")
    public ResponseEntity<Page<Contract>> findByName(@RequestParam(defaultValue = "", name = "n") String name,
                                                     @PageableDefault(size = MAX_DISPLAY, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return new ResponseEntity<>(service.findByName(name, pageable), HttpStatus.OK);
    }

    // find contract according to id
    @GetMapping("/{id}")
    public ResponseEntity<Contract> findById(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(service.findById(id), HttpStatus.ACCEPTED);
    }

    // delete contract
    @GetMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) throws Exception {
        service.deleteById(id);
        return ResponseEntity.ok("Customer with id " + id + " has been deleted.");
    }

    // create and update contract
    @PostMapping("/create")
    public Contract updateOrCreate(@RequestBody Contract contract){
        return service.updateOrCreate(contract);
    }
}
