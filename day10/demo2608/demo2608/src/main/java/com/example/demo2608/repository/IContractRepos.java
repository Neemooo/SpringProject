package com.example.demo2608.repository;

import com.example.demo2608.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IContractRepos extends JpaRepository<Contract, Long> {

    // search contract according to customer name:
@Query("SELECT c FROM Contract c INNER JOIN Customer cus ON cus.id = c.customer.id AND cus.name LIKE CONCAT('%', :name, '%')")
Page<Contract> findByName(@Param("name") String name, Pageable pageable);


}
