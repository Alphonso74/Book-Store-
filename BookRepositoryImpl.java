package mobyDickensBookStore.repository.impl;

import com.google.common.collect.MoreCollectors;
import mobyDickensBookStore.model.Book;
import mobyDickensBookStore.repository.BookRepository;
import org.springframework.stereotype.Repository;

import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BookRepositoryImpl implements BookRepository {

    // Instance data
    private List<Book> books = new ArrayList<>();

    @Override
    public List<Book> findAllBooks() {
        return books;
    }

    @Override
    public Book findBookById(Integer bookId) {

        return books.stream()
                .filter(game -> game.getBookID().equals(bookId))
                .collect(MoreCollectors.onlyElement());

//        for (Book game : books) {
//            if (game.getGameId() != null && game.getGameId().equals(gameId)) {
//                return game;
//            }
//        }
//        return null;
    }

    @Override
    public Book addBook(Integer bookId, String title, Long ISBN, String author, Integer datePublished, Double bookPrice, String genre) {
        Book toAdd = new Book(bookId, title, ISBN, author, datePublished, bookPrice, genre);
        books.add(toAdd);
        return toAdd;
    }

    @Override
    public List<Book> findAllBooksFiltered(String filterName) {
        return books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(filterName.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteBook(Integer bookId) {

        Book candidate = null;
        for (Book book : books) {
            if (book.getBookID().equals(bookId)) {
                // remove it from list
                candidate = book;
            }
        }

        if (candidate != null) {
            books.remove(candidate);
        }
    }

    @Override
    public Book editbook(Integer bookId, String title, Long ISBN, String author, Integer datePublished, Double bookPrice, String genre) {
        Book candidate = null;
        for (Book book : books) {
            if (book.getBookID().equals(bookId)) {
                candidate = book;
            }
        }

        // edit
        if (candidate != null) {
            candidate.setTitle(title);
            candidate.setBookPrice(Double.valueOf(bookPrice));
            candidate.setAuthor(author);
            candidate.setISBN(ISBN);
            candidate.setDatePublished(Integer.valueOf(datePublished));
            candidate.setGenre(genre);
        }

        return candidate;
    }
}
