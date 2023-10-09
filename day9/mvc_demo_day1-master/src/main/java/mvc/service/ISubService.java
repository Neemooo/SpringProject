package mvc.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ISubService<E> {
    List<E> findAll();
}
