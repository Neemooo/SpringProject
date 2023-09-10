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

    // Hiển thị danh sách các Sách không có tên là Java
    List<Book> findAllByNameNotLike(String name);

    // Hiển thị danh sách các Sách có ngày publishDate bé hơn ngày hiện tại
    List<Book> findAllByPublishDateBefore(Date currentDate);

    // Update toàn bộ Sách có Giá lớn hơn 100 (oldprice) thành giá 90(newPrice)
    @Modifying
    @Transactional
    @Query(value = "update Book c set c.price = ?1 where c.price > ?2")
    void updateByPrice(Double newPrice, Double oldPrice);

    // Xoá toàn bộ Sách có tên là Java và tác giả là Jonh
    @Modifying
    @Transactional
    void deleteAllByNameLikeAndAuthorLike(String name, String author);

    // Tim toan bo Sach cho gia 100
    List<Book> findAllByPriceEquals(Double price);

    // Tim toan bo Sach co nam la ? va author la ?
    List<Book> findAllByNameLikeAndAuthorLike(String name, String author);

    List<Book> findAllByAuthorLike(String author);

    List<Book> findAllByAuthorLikeAndPrice(String author, Double price);

    List<Book> findAllByPriceOrNumberOfPage(Double price,int pages);

    List<Book> findAllByPriceLessThan(Double price);

    List<Book> findAllByPriceGreaterThanEqual(Double price);

    List<Book> findAllByNameContaining(String name);

    List<Book> findAllByIsbnLike(String name);

    List<Book> findAllByPublishDateAfter(LocalDate date);
 }
