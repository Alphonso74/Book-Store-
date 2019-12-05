package mobyDickensBookStore.service;

import mobyDickensBookStore.model.Book;

import java.util.List;

public interface BookService {
    List<Book> findAllBooks();
    Book findBookById(Integer bookId);

    List<Book> findAllBooksFiltered(String filterName);

    Book addBook(Integer bookId, String title, Long ISBN, String author, Integer datePublished, Double bookPrice, String genre);

    void deleteBook(Integer bookId);

    Book editBook(Integer bookId, String title, Long ISBN, String author, Integer datePublished, Double bookPrice, String genre);
}
