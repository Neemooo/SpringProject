package com.example.demo2608.repository;

import com.example.demo2608.model.type.Rent_type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRentTypeRepos extends JpaRepository<Rent_type, Long> {
}
