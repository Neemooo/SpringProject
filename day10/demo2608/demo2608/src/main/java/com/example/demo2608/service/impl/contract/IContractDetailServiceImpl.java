package com.example.demo2608.service.impl.contract;

import com.example.demo2608.model.Contract_detail;
import com.example.demo2608.repository.IContractDetailRepos;
import com.example.demo2608.service.IBaseService;
import com.example.demo2608.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IContractDetailServiceImpl implements IBaseService<Contract_detail>, IContractDetailService {
    @Autowired
    IContractDetailRepos repos;

    @Override
    public Page<Contract_detail> findAll(Pageable pageable) {
        return repos.findAll(pageable);
    }

    // search contract according to customer name;
    @Override
    public Page<Contract_detail> findByName(String name, Pageable pageable) {
        return repos.findByName(name, pageable);
    }

    @Override
    public Contract_detail findById(Long id) throws Exception {
        Optional<Contract_detail>isExisted=repos.findById(id);

        if(isExisted.isPresent()){
            return isExisted.get();
        }

        throw new Exception("No contract record exist for given id "+id);
    }

    @Override
    public Contract_detail updateOrCreate(Contract_detail contractDetail) {
        if(contractDetail.getId()==null){
            repos.save(contractDetail);
        }
        Optional<Contract_detail> isExisted=repos.findById(contractDetail.getId());

        return isExisted.map(value->repos.save(value)).orElseGet(()->repos.save(contractDetail));
    }

    @Override
    public void deleteById(Long id) throws Exception {
        Optional<Contract_detail> isExisted=repos.findById(id);
        if(isExisted.isPresent()){
            repos.deleteById(id);
        }
        throw new Exception("No contract record exist for given id "+ id);
    }

    @Override
    public List<Contract_detail> findByIdContract(Long id) throws Exception {
        List<Contract_detail>isExisted=repos.findByIdOfContract(id);

        if(isExisted!=null){
            return isExisted;
        }

        throw new Exception("No contract record exist for given id "+id);
    }
}
