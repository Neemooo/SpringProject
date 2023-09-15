package repository;

import models.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface OrderDetailRepos extends JpaRepository<OrderDetail, Long> {

    List<OrderDetail> findAllByOrderId(Long id);

    @Modifying
    @Transactional
    void deleteByOrderId(Long id);
}
