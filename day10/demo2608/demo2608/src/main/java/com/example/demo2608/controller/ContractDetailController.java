package com.example.demo2608.controller;

import com.example.demo2608.model.Contract_detail;
import com.example.demo2608.service.IBaseService;
import com.example.demo2608.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contractDetail")

public class ContractDetailController {

    final int MAX_DISPLAY = 5;

    @Autowired
    IBaseService<Contract_detail> service;

    @Autowired
    IContractDetailService listOfContract;

    // show list contract_detail according with total record for each page that is 5 record;
    @GetMapping("")
    public ResponseEntity<Page<Contract_detail>> findAll(@PageableDefault(size = MAX_DISPLAY, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return new ResponseEntity<>(service.findAll(pageable), HttpStatus.OK);
    }

    // show contract_detail according to customer name:
    @GetMapping("/findByName")
    public ResponseEntity<Page<Contract_detail>> findByName(@RequestParam(defaultValue = "", name = "n") String name,
                                                     @PageableDefault(size = MAX_DISPLAY, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return new ResponseEntity<>(service.findByName(name, pageable), HttpStatus.OK);
    }

    // find according to id
    @GetMapping("/{id}")
    public ResponseEntity<Contract_detail> findById(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(service.findById(id), HttpStatus.ACCEPTED);
    }

    // find according to id of contract
    @GetMapping("/listOfContract/{id}")
    public ResponseEntity<List<Contract_detail>> findByIdContract(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(listOfContract.findByIdContract(id), HttpStatus.ACCEPTED);
    }

    // delete
    @GetMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) throws Exception {
        service.deleteById(id);
        return ResponseEntity.ok("Customer with id " + id + " has been deleted.");
    }

    // create and update employee
    @PostMapping("/create")
    public ResponseEntity<Contract_detail> updateOrCreate(@RequestBody Contract_detail contractDetail){
        return new ResponseEntity<>(service.updateOrCreate(contractDetail), HttpStatus.OK);
    }
}
