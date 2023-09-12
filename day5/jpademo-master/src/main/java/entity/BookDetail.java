package entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bookDetail")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@ToString
public class BookDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="id")
    private Long id;

    @Column (name="isbn")
    private String isbn;

    @Column (name="numberOfPage")
    private Integer numberOfPage;

    @Column (name="price")
    private Integer price;

    @Column (name="publishDate")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "YYYY-MM-dd")
    private Date publishDate;

    @OneToOne(mappedBy = "bookDetail")
    private Book book;
}
