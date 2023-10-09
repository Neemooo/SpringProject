package mvc.service.impl;

import mvc.models.Product;
import mvc.repository.ProductRepository;
import mvc.service.ISubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements ISubService<Product> {
    @Autowired
    ProductRepository repos;

    public Optional<Product> findById(Long id){
        return repos.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return repos.findAll();
    }
}
