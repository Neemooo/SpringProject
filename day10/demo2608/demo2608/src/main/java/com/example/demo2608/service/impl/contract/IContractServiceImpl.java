package com.example.demo2608.service.impl.contract;

import com.example.demo2608.model.Contract;
import com.example.demo2608.repository.IContractRepos;
import com.example.demo2608.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IContractServiceImpl implements IBaseService<Contract> {

    @Autowired
    IContractRepos repos;

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return repos.findAll(pageable);
    }

    // search contract according to customer name;
    @Override
    public Page<Contract> findByName(String name, Pageable pageable) {
        return repos.findByName(name, pageable);
    }

    @Override
    public Contract findById(Long id) throws Exception {
        Optional<Contract> isExisted=repos.findById(id);

        if(isExisted.isPresent()){
           return isExisted.get();
        }

        throw new Exception("No contract record exist for given id "+id);
    }

    @Override
    public Contract updateOrCreate(Contract contract) {
        if(contract.getId()==null){
            repos.save(contract);
        }
        Optional<Contract> isExisted=repos.findById(contract.getId());

       return isExisted.map(value->repos.save(value)).orElseGet(()->repos.save(contract));
    }

    @Override
    public void deleteById(Long id) throws Exception {
        Optional<Contract> isExisted=repos.findById(id);
        if(isExisted.isPresent()){
            repos.deleteById(id);
        }
        throw new Exception("No contract record exist for given id "+ id);
    }
}
