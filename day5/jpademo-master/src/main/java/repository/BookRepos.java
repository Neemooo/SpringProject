package repository;

import entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface BookRepos extends CrudRepository<Book, Long> {
    List<Book> findAllByAuthorLike(String author);

    List<Book> findAllByNameLikeAndAuthorLike(String name, String author);

    List<Book> findAllByNameLikeOrAuthorLike(String name, String author);

    Book findByBookDetailIsbn(String name);

    List<Book> findAllByBookDetailPriceLessThan(Integer price);

    List<Book> findAllByBookDetailPriceLessThanEqual(Integer price);

    List<Book> findAllByBookDetailPriceGreaterThanEqual(Integer price);

    List<Book> findAllByNameContaining(String name);
 }
