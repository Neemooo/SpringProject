package com.example.demo2608.service.impl.employee;

import com.example.demo2608.model.Employee;
import com.example.demo2608.repository.IEmployeeRepos;
import com.example.demo2608.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class IEmployeeServiceImpl implements IBaseService<Employee> {
    @Autowired
    IEmployeeRepos repos;

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return repos.findAll(pageable);
    }

    @Override
    public Page<Employee> findByName(String name, Pageable pageable) {
        return repos.findAllByNameContaining(name, pageable);
    }

    @Override
    public Employee findById(Long id) throws Exception {
        Optional<Employee> isExisted= repos.findById(id);
        if(isExisted.isPresent()){
            return isExisted.get();
        }
        throw new Exception("No employee record exist for given id "+id);
    }

    @Override
    public Employee updateOrCreate(Employee employee) {
        if(employee.getId()==null){
            return repos.save(employee);
        }
            Optional<Employee> employee1=repos.findById(employee.getId());
//            if(employee1.isPresent()){
//                Employee employee2=employee1.get();
////                employee2.setName(employee.getName());
////                employee2.setBirthday(employee.getBirthday());
////                employee2.setId_card(employee.getId_card());
////                employee2.setSalary(employee.getSalary());
////                employee2.setPhone(employee.getPhone());
////                employee2.setEmail(employee.getEmail());
////                employee2.setDivision(employee.getDivision());
////                employee2.setPosition(employee.getPosition());
////                employee2.setEducation(employee.getEducation());
////                employee2.setUsers(employee.getUsers());
//                return repos.save(employee1.get());
//            }
//                return repos.save(employee);
        return employee1.map(value -> repos.save(value)).orElseGet(() -> repos.save(employee));
    }

    @Override
    public void deleteById(Long id) throws Exception {
        Optional<Employee> isExisted=repos.findById(id);
        if(isExisted.isPresent()){
            repos.deleteById(id);
        } else {
            throw new Exception("No employee record exist for given id "+ id);
        }

    }


}
