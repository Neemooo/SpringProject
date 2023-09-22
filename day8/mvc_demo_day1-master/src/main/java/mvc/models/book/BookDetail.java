package mvc.models.book;

import mvc.dto.BookDetailDTO;
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

    public BookDetail(BookDetailDTO bookDetailDTO){
        Book book=new Book();
        this.id=null;
        this.isbn=bookDetailDTO.getIsbn();
        this.numberOfPage=bookDetailDTO.getNumberOfPage();
        this.price=bookDetailDTO.getPrice();
        this.publishDate=bookDetailDTO.getPublishDate();
        this.book.setId(bookDetailDTO.getId());
    }
}
