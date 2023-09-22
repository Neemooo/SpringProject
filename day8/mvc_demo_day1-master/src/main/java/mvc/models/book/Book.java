package mvc.models.book;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "book")
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

    @Column (name="author")
    private String author;

    @Column (name="name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "categoryId", nullable = false, referencedColumnName = "id")
    Category category;

    @OneToOne
    @PrimaryKeyJoinColumn
    BookDetail bookDetail;

    public Book(BookDTO bookDTO){

        this.id=null;
        this.author=bookDTO.getAuthor();
        this.name=bookDTO.getName();

        BookDetail bookDetail=new BookDetail();
        this.bookDetail.setId(null);

        Category category=new Category();
        this.category.setId(bookDTO.getCategoryId());
    }
}
