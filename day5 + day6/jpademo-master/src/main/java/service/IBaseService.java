package service;

import entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBaseService<E> {
    Book save(E e);

    List<E> findAll();

    void updateById(Book book);

    void deleteById(Long id);

    Optional<E> findById(Long id);
}
