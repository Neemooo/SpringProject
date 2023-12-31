package repository;

import models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface OrderRepos extends JpaRepository<Order, Long> {

    @Query("FROM Order o WHERE FUNCTION('MONTH',o.orderDate) = :month")
    List<Order> findAllByOrderDate_Month(@Param("month") Integer month);

    List<Order> findAllByOrderDetailProductName(String name);

    List<Order> findAllByCustomerNameLike(String name);
}
