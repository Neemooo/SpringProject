package mvc.service.interface_book;

import mvc.models.book.Book;
import mvc.service.IBaseService;

import java.util.List;

public interface IBookService extends IBaseService<Book> {
    List<Book> findAll();
}
