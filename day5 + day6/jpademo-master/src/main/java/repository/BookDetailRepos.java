package repository;

import entity.BookDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDetailRepos extends JpaRepository<BookDetail, Long> {
}
