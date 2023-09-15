package service;

import models.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Service;
import repository.OrderDetailRepos;

@Service
public class OrderDetailService {
    @Autowired
    JpaTransactionManager jpaTransactionManager;

    @Autowired
    OrderDetailRepos repos;

    public void insertOrderDetail(OrderDetail orderDetail){
        repos.save(orderDetail);
    }

    public void deleteAllByOrderById(Long id){
        repos.deleteByOrderId(id);
    }
}
