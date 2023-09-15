
package models;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "orderDetails")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@ToString
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "orderId", nullable = false, referencedColumnName = "id")
    Order order;

    @Column (name="productName")
    private String productName;

    @Column (name="quantity")
    private Integer quantity;

    @Column (name="unitPrice")
    private Double unitPrice;

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
