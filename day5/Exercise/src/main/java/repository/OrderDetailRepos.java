package repository;

import models.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepos extends JpaRepository<OrderDetail, Long> {
    List<OrderDetail> findAllByOrderId(Long id);
}
