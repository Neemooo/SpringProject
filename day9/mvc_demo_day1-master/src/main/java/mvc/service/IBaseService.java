package mvc.service;

import java.util.List;
import java.util.Optional;

public interface IBaseService<E> {
    List<E> findAllByName(String keyword);

    Optional<E> findById(Long id);

    void save(E e);

    void deletedById(Long id);
}
