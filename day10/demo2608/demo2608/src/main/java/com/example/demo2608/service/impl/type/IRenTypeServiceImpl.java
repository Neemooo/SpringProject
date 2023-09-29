package com.example.demo2608.service.impl.type;

import com.example.demo2608.model.type.Rent_type;
import com.example.demo2608.repository.IRentTypeRepos;
import com.example.demo2608.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IRenTypeServiceImpl implements IServiceService<Rent_type> {
    @Autowired
    IRentTypeRepos repos;
    @Override
    public List<Rent_type> findAll() {
        return repos.findAll();
    }

    @Override
    public Rent_type findById(Long id) throws Exception {
        Optional<Rent_type> isExisted=repos.findById(id);
        if(isExisted.isPresent()){
           return isExisted.get();
        }
        throw new Exception("No service-type record exist for given id "+id);
    }

    @Override
    public void deleteById(Long id) throws Exception {
        Optional<Rent_type> isExisted=repos.findById(id);
        if(isExisted.isPresent()){
            repos.deleteById(id);
        } else {
            throw new Exception("No Rent_Type record exist for given id "+ id);
        }
    }

    @Override
    public Rent_type update(Rent_type rent_type) {
        return null;
    }

    @Override
    public Rent_type save(Rent_type rent_type) {
        return null;
    }
}
