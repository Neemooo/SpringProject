package com.example.demo2608.service.impl.type;

import com.example.demo2608.model.type.Service_type;
import com.example.demo2608.repository.IServiceTypeRepos;
import com.example.demo2608.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IServiceTypeServiceImpl implements IServiceService<Service_type> {

    @Autowired
    IServiceTypeRepos repos;

    @Override
    public List<Service_type> findAll() {
        return repos.findAll();
    }

    @Override
    public Service_type findById(Long id) throws Exception {
        Optional<Service_type> isExisted=repos.findById(id);
        if(isExisted.isPresent()){
            return isExisted.get();
        }
        throw new Exception("No service-type record exist for given id "+id);
    }

    @Override
    public void deleteById(Long id) throws Exception {
        Optional<Service_type> isExisted=repos.findById(id);
        if(isExisted.isPresent()){
            repos.deleteById(id);
        } else {
            throw new Exception("No service-type record exist for given id "+id);
        }

    }

    @Override
    public Service_type update(Service_type service_type) {
        return null;
    }

    @Override
    public Service_type save(Service_type service_type) {
        if(service_type.getId()==null){
            return repos.save(service_type);
        }
        Optional<Service_type> isExisted=repos.findById(service_type.getId());

        return isExisted.map(serviceType -> repos.save(serviceType)).orElseGet(() -> repos.save(service_type));
    }
}
