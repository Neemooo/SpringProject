package mvc.dto;

import lombok.*;
import mvc.models.book.Book;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class BookDTO {
    private Long id;

    @NotBlank(message = "author should be written something")
    private String author;

    @NotBlank(message = "name should be written something")
    private String name;

    @NotBlank(message = "category should be written something")
    private Long categoryId;

    public BookDTO(Book book){
       this.id=book.getId();
       this.author=book.getAuthor();
       this.name=book.getName();
       this.categoryId=book.getCategory().getId();
    }
}
