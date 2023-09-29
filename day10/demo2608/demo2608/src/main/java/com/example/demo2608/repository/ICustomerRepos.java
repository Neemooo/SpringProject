package com.example.demo2608.repository;

import com.example.demo2608.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ICustomerRepos extends JpaRepository<Customer, Long> {
    Page<Customer> findAllByNameContaining(String name, Pageable pages);

}
