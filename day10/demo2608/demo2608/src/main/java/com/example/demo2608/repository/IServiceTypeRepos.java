package com.example.demo2608.repository;

import com.example.demo2608.model.type.Service_type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IServiceTypeRepos extends JpaRepository<Service_type, Long> {

}
