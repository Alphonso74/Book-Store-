package mobyDickensBookStore.repository;

import mobyDickensBookStore.model.Book;

import java.util.List;

public interface BookRepository {
    List<Book> findAllBooks();

    Book findBookById(Integer BookId);

    Book addBook(Integer bookId, String title, Long ISBN, String author, Integer datePublished, Double bookPrice, String genre);

    List<Book> findAllBooksFiltered(String filterName);

    void deleteBook(Integer bookId);

    Book editbook(Integer bookId, String title, Long ISBN, String author, Integer datePublished, Double bookPrice, String genre);
}
