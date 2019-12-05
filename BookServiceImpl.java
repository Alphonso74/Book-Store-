package mobyDickensBookStore.service.impl;

import mobyDickensBookStore.model.Book;
import mobyDickensBookStore.repository.BookRepository;
import mobyDickensBookStore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    //
    //  Instance Data

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAllBooks();
    }

    @Override
    public Book findBookById(Integer bookId) {
        return bookRepository.findBookById(bookId);
    }

    @Override
    public List<Book> findAllBooksFiltered(String filterName) {
        return bookRepository.findAllBooksFiltered(filterName);
    }

    @Override
    public Book addBook(Integer bookId, String title, Long ISBN, String author, Integer datePublished, Double bookPrice, String genre) {
        return bookRepository.addBook(bookId, title, ISBN, author, datePublished,bookPrice,genre);
    }

    @Override
    public void deleteBook(Integer bookId) {
        bookRepository.deleteBook(bookId);
    }

    @Override
    public Book editBook(Integer bookId, String title, Long ISBN, String author, Integer datePublished, Double bookPrice, String genre) {
        return bookRepository.editbook(bookId, title, ISBN, author, datePublished, bookPrice, genre);
    }
//
//    public BookServiceImpl() {
//        this.bookRepository = new BookRepositoryImpl();
//    }
}
