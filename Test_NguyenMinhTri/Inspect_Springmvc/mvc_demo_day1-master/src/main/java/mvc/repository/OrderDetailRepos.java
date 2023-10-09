package mvc.repository;

import mvc.models.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderDetailRepos extends JpaRepository<OrderDetail,Long> {
   List<OrderDetail> findAllByOrderId(Long id);

   Optional<OrderDetail> findAllByOrderOrderDateAndOrderCustomerNameAndAndProductName(Date date, String customerName, String productName);
}
