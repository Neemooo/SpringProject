package entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Book")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="id")
    private Long id;

    @Column (name="name")
    private String name;

    @Column (name="author")
    private String author;

    @Column (name="category")
    private String category;

    @Column (name="isbn")
    private String isbn;

    @Column (name="price")
    private Double price;

    @Column (name="numberPage")
    private Integer numberOfPage;

    @Column (name="publishDate")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "YYYY-MM-dd")
    private Date publishDate;

}
