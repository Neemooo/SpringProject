package mvc.service;

import mvc.models.OrderDetail;
import mvc.repository.OrderDetailRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailService {
    @Autowired
    OrderDetailRepos repos;

    public List<OrderDetail> findByOrderId(Long id){
        return repos.findAllByOrderId(id);
    }

    public Optional<OrderDetail> search(Date date, String customerName, String productName){
        return repos.findAllByOrderOrderDateAndOrderCustomerNameAndAndProductName(date, customerName, productName);
    }
}
