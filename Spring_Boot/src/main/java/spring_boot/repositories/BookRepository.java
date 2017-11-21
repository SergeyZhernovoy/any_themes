package spring_boot.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring_boot.entity.Book;

/**
 * @author Sergey Zhernovoy
 * create on 21.11.2017.
 */

@Repository
public interface BookRepository extends CrudRepository<Book,Long> {
    public Book findBookByIsbn(String isbn);
}
