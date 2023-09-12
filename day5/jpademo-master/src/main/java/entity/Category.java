package entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@ToString
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="id")
    private Long id;

    @Column (name="description")
    private String description;

    @Column (name="name")
    private String name;

    @OneToMany (mappedBy = "category", fetch = FetchType.EAGER)
    private List<Book> bookList;

}
