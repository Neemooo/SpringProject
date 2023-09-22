package mvc.service.impl;

import mvc.models.book.BookDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mvc.repository.bookRepos.BookDetailRepository;
import mvc.service.interface_book.IBookDetailService;

import java.util.List;
import java.util.Optional;

@Service
public class BookDetailImpl implements IBookDetailService {
@Autowired
    BookDetailRepository repos;

    @Override
    public List<BookDetail> findAllByName(String keyword) {
        return null;
    }

    @Override
    public Optional<BookDetail> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(BookDetail bookDetail) {

    }


    @Override
    public void deletedById(Long id) {

    }
}
