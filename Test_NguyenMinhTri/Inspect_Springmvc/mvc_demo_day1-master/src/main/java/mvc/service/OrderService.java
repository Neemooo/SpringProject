package mvc.service;

import mvc.models.Order;
import mvc.repository.OrderRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepos repos;

    public List<Order> findAll(){
        return repos.findAll();
    }
}
