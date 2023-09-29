package com.example.demo2608.repository;

import com.example.demo2608.model.Contract;
import com.example.demo2608.model.Contract_detail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IContractDetailRepos extends JpaRepository<Contract_detail, Long> {
    @Query("SELECT con FROM Contract_detail con INNER JOIN Contract c ON c.id=con.contract.id INNER JOIN Customer cus ON cus.id=c.customer.id WHERE cus.name LIKE CONCAT('%', :name, '%') ")
    Page<Contract_detail> findByName(String name, Pageable pageable);

    @Query("SELECT con FROM Contract_detail  con INNER JOIN Contract c ON c.id=con.contract.id WHERE c.id=:id")
    List<Contract_detail> findByIdOfContract(Long id);
}
