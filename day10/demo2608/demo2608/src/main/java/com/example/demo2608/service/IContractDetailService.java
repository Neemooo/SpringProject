package com.example.demo2608.service;


import com.example.demo2608.model.Contract_detail;

import java.util.List;

public interface IContractDetailService {
    List<Contract_detail> findByIdContract(Long id) throws Exception;
}
