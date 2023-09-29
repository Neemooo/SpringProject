package com.example.demo2608.repository;

import com.example.demo2608.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IServiceRepos extends JpaRepository<Service, Long> {
//    List<Service> findAll();
}
