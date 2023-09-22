package mvc.dto;

import lombok.*;
import mvc.models.book.BookDetail;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class BookDetailDTO {

    private Long id;

    @NotBlank(message = "isbn should be written something")
    private String isbn;

    @NotBlank(message = "numberOfPage should be written something")
    private Integer numberOfPage;

    @NotBlank(message = "price should be written something")
    private Integer price;

    @NotBlank(message = "publishDate should be written something")
    private Date publishDate;

    public BookDetailDTO(BookDetail bookDetail){
        this.id=bookDetail.getId();
        this.isbn=bookDetail.getIsbn();
        this.numberOfPage=bookDetail.getNumberOfPage();
        this.price=bookDetail.getPrice();
        this.publishDate=bookDetail.getPublishDate();
    }
}
