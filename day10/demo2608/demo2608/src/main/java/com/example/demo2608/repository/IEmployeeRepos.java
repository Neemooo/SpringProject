package com.example.demo2608.repository;

import com.example.demo2608.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface IEmployeeRepos extends JpaRepository<Employee, Long> {

    Page<Employee> findAllByNameContaining(String name, Pageable pages);


}
