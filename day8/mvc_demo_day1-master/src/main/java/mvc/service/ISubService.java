package mvc.service;

import java.util.List;

public interface ISubService<E> {
    List<E> findAll();
}
