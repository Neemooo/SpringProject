package com.example.demo2608.controller;

import com.example.demo2608.model.Employee;
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
@RequestMapping("/api/employee")
public class EmployeeController {
    final int MAX_DISPLAY = 5;
    @Autowired
    IBaseService<Employee> service;

    // show list employees according with total record for each page that is 5 record;
    @GetMapping("")
    public ResponseEntity<Page<Employee>> findAll(@PageableDefault(size = MAX_DISPLAY, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return new ResponseEntity<>(service.findAll(pageable), HttpStatus.OK);
    }

    // show employee according to name
    @GetMapping("/findByName")
    public ResponseEntity<Page<Employee>> findByName(@RequestParam(defaultValue = "", name = "n") String name,
                                                  @PageableDefault(size = MAX_DISPLAY, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return new ResponseEntity<>(service.findByName(name, pageable), HttpStatus.OK);
    }

    // find employee according to id
    @GetMapping("/{id}")
    public ResponseEntity<Employee> findById(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(service.findById(id), HttpStatus.ACCEPTED);
    }

    // deleteById don't finished:
    @GetMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) throws Exception {
        service.deleteById(id);
        return ResponseEntity.ok("Employee with id " + id + " has been deleted.");
    }


    // create and update employee
    @PostMapping("/create")
    public Employee updateOrCreate(@RequestBody Employee employee){
        return service.updateOrCreate(employee);
    }
}
