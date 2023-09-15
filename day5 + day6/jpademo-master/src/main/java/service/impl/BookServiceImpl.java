package service.impl;

import entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import repository.BookRepos;
import service.IBookService;

import javax.print.DocFlavor;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements IBookService {
    @Autowired
    BookRepos repos;
    @Override
    public Book save(Book book) {
       return repos.save(book);
    }

    @Override
    public List<Book> findAll() {
        return (List<Book>) repos.findAll();
    }

    @Override
    public void updateById(Book book) {
        repos.save(book);
    }

    @Override
    public void deleteById(Long id) {
        repos.deleteById(id);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return repos.findById(id);
    }
}
