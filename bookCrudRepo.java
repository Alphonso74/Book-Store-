package mobyDickensBookStore.jpa;
import org.springframework.data.repository.CrudRepository;
import mobyDickensBookStore.model.Book;

import java.util.List;

public interface bookCrudRepo extends CrudRepository<Book, Integer> {

    List<Book> findByTitleContainingIgnoreCase (String title );
    //List<Book> findByISBN(long ISBN);
    List<Book> findByBookID(Integer bookID);

}
