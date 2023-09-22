package mvc.service.impl;

import mvc.models.book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import mvc.repository.bookRepos.BookRepository;
import mvc.service.interface_book.IBookService;
import java.util.List;
import java.util.Optional;

public class BookServiceImpl implements IBookService {
    @Autowired
    BookRepository repos;

    @Override
    public List<Book> findAll() {
        return repos.findAll();
    }

    @Override
    public List<Book> findAllByName(String keyword) {
        return repos.findAllByNameContaining(keyword);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return repos.findById(id);
    }

    @Override
    public void save(Book book) {
        repos.save(book);
    }

    @Override
    public void deletedById(Long id) {
        repos.deleteById(id);
    }

}
