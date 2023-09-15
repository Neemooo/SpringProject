package service;

import models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.OrderRepos;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    JpaTransactionManager jpaTransactionManager;

    @Autowired
    OrderRepos repos;

    @Transactional
    public void insertOrder(Order order){
        repos.save(order);
    }

    public Optional<Order> findById(Long id){
        return repos.findById(id);
    }

    public List<Order> findAll(){
        return repos.findAll();
    }

    public List<Order> findAllByOrderDate_Month(Integer month){
        return repos.findAllByOrderDate_Month(month);
    }

    public List<Order> findAllByOrderDetailProductName(String name){
        return repos.findAllByOrderDetailProductName(name);
    }

    public List<Order> findAllByCustomerNameLike(String name){
        return repos.findAllByCustomerNameLike(name);
    }

    public void deleteById(Long id){
        repos.deleteById(id);
    }


}
