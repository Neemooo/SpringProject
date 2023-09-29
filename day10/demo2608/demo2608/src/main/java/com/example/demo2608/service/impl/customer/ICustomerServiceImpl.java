package com.example.demo2608.service.impl.customer;

import com.example.demo2608.model.Customer;
import com.example.demo2608.repository.ICustomerRepos;
import com.example.demo2608.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ICustomerServiceImpl implements IBaseService<Customer> {
    @Autowired
    ICustomerRepos repos;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return repos.findAll(pageable);
    }

    @Override
    public Page<Customer> findByName(String name, Pageable pageable) {
        return repos.findAllByNameContaining(name, pageable);
    }

    @Override
    public Customer findById(Long id) throws Exception {
        Optional<Customer> isExisted=repos.findById(id);
        if(isExisted.isPresent()){
           return isExisted.get();
        }
        throw new Exception("No Customer record exist for given id "+id);
    }

    @Override
    public Customer updateOrCreate(Customer customer) {
//        if(customer.getId()==null){
//           return repos.save(customer);
//        }
//        Optional<Customer> isExisted=repos.findById(customer.getId());
//        if(isExisted.isPresent()){
//
//        }

        return repos.save(customer);
    }

    @Override
    public void deleteById(Long id) throws Exception {
        Optional<Customer> isExisted=repos.findById(id);
        if(isExisted.isPresent()){
            repos.deleteById(id);
        } else {
            throw new Exception("No Customer record exist for given id "+id);
        }

    }
}
