package mvc.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "orderDetail")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "orderId", nullable = false, referencedColumnName = "id")
    Order order;

    @ManyToOne
    @JoinColumn(name = "productId", nullable = false, referencedColumnName = "id")
    Product product;

    @Column (name="quantity")
    private Integer quantity;
}
