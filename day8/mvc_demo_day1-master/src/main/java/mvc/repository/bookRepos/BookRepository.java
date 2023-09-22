package mvc.repository.bookRepos;

import mvc.models.book.Book;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepositoryImplementation<Book,Long> {

    List<Book> findAllByAuthorLike(String author);

    List<Book> findAllByNameLikeAndAuthorLike(String name, String author);

    List<Book> findAllByNameLikeOrAuthorLike(String name, String author);

    Book findByBookDetailIsbn(String name);

    List<Book> findAllByBookDetailPriceLessThan(Integer price);

    List<Book> findAllByBookDetailPriceLessThanEqual(Integer price);

    List<Book> findAllByBookDetailPriceGreaterThanEqual(Integer price);

    List<Book> findAllByNameContaining(String name);

    @Modifying
    @Transactional
    void deleteById(Long id);
}
