package com.example.demo2608.service.impl.services;

import com.example.demo2608.model.Service;
import com.example.demo2608.repository.IServiceRepos;
import com.example.demo2608.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class IServicesServiceImpl implements IServiceService<Service> {

    @Autowired
    IServiceRepos repos;

    @Override
    public List<Service> findAll() {
        return repos.findAll();
    }

    @Override
    public Service findById(Long id) throws Exception {
        Optional<Service> service=repos.findById(id);
        if(service.isPresent()){
           return service.get();
        }
        throw new Exception("No service record exist for given id "+id);
    }

    @Override
    public void deleteById(Long id) throws Exception {
        Optional<Service> isExisted=repos.findById(id);
        if(isExisted.isPresent()){
            repos.deleteById(id);
        } else {
            throw new Exception("No service record exist for given id "+ id);
        }
    }

    @Override
    public Service update(Service service) {
        return null;
    }

    @Override
    public Service save(Service service) {
        return null;
    }
}
