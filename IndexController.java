package mobyDickensBookStore.controller;

import mobyDickensBookStore.jpa.bookCrudRepo;
import mobyDickensBookStore.model.Book;
import mobyDickensBookStore.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
public class IndexController {

    //
    //  Instance Data

    @Autowired
    private bookCrudRepo repo;
    //private BookService bookService;

//
//    public IndexController() {
//        this.bookService = new BookServiceImpl();
//    }

    //
    //  Index Page

    @GetMapping(value = "/")
    public String indexPage(Model model) {
//        List<Book> bookList = bookService.findAllBooks();
//        model.addAttribute("bookList", bookList);
//        System.out.println("book list" + bookList.size());
//        System.out.println(bookList.get(0).getBookID());
        List<Book> bookList = (List<Book>) repo.findAll();
        model.addAttribute("bookList", bookList);
        return "index";
    }

    @PostMapping(value = "/")
    public String filteredIndexPage(@RequestParam String filterName, Model model) {
//        List<Book> bookList = bookService.findAllBooksFiltered(filterName);
//        model.addAttribute("bookList", bookList);
        List<Book> bookList = repo.findByTitleContainingIgnoreCase(filterName);
        model.addAttribute("bookList", bookList);

        return "index";
    }

    //
    //  Filter

    //
    //  Adding Book
    @GetMapping(value = "/admin/books/add")
    public String addGamePage() {
        return "addbook";
    }

    @PostMapping(value = "/admin/books/add")
    public String addGameForm(@RequestParam Integer bookID,@RequestParam String title,@RequestParam Long ISBN, @RequestParam String author, @RequestParam Integer datePublished,@RequestParam Double bookPrice,@RequestParam String genre) {
//        bookService.addBook(bookId,title, ISBN, author, datePublished, bookPrice, genre);
        Book book = new Book(bookID,title, ISBN, author, datePublished, bookPrice, genre);
        repo.save(book);
        return "redirect:/";
    }

    //
    //  Edit Book
    @GetMapping(value = "/admin/books/edit/{bookId}")
    public String editBookPage(@PathVariable(value = "bookId") Integer bookId, Model model) {

        if (bookId == null || bookId <= 0) {
            throw new IllegalStateException("Book ID is required!");
        }

        Book book = repo.findByBookID(bookId).get(0);

        //  Attempt to find the book

        if (book != null) {
            model.addAttribute("bookId", book.getBookID());
            model.addAttribute("title", book.getTitle());
            model.addAttribute("ISBN", book.getISBN());
            model.addAttribute("author", book.getAuthor());
            model.addAttribute("datePublished", book.getDatePublished());
            model.addAttribute("bookPrice", book.getBookPrice());
            model.addAttribute("genre", book.getGenre());

        }

        else {


            System.out.println("Was not found");
            System.out.println("bookId:" + bookId);
            return "index";
        }
            return "editbook";

    }

    @GetMapping(value = "/admin/books/view")
    public String ViewPage(Model model) {
//        List<Book> bookList = bookService.findAllBooks();
//        model.addAttribute("bookList", bookList);
        List<Book> bookList = (List<Book>) repo.findAll();
        model.addAttribute("bookList", bookList);
        return "view";
    }



    @PostMapping(value = "/admin/books/view")
    public String filteredSearchPage2(@RequestParam String filterName, Model model) {
//        List<Book> bookList = bookService.findAllBooksFiltered(filterName);
//        model.addAttribute("bookList", bookList);
        List<Book> bookList = repo.findByTitleContainingIgnoreCase(filterName);
        model.addAttribute("bookList", bookList);
        return "view";
    }

    @PostMapping(value = "/search")
    public String filteredSearchPage(@RequestParam String filterName, Model model) {
//        List<Book> bookList = bookService.findAllBooksFiltered(filterName);
//        model.addAttribute("bookList", bookList);
        List<Book> bookList = repo.findByTitleContainingIgnoreCase(filterName);
        model.addAttribute("bookList", bookList);
        return "search";
    }

    @PostMapping(value = "/admin/books/edit")
    public String editBook(@RequestParam Integer bookId,@RequestParam String title,@RequestParam Long ISBN, @RequestParam String author, @RequestParam Integer datePublished,@RequestParam Double bookPrice,@RequestParam String genre) {

//        if (bookId == null || bookId <= 0) {
//            throw new IllegalStateException("Book ID is required!");
//        }
//        Book books = bookService.editBook(bookId,title, ISBN, author, datePublished, bookPrice, genre);
//        //log.debug("Book edit successful with ID " + book.getBookID());

        List<Book> books= repo.findByBookID(bookId);
        Book book = books.get(0);
        book.setTitle(title);
        book.setAuthor(author);
        book.setBookID(bookId);
        book.setBookPrice(bookPrice);
        book.setGenre(genre);
        book.setDatePublished(datePublished);
        repo.save(book);

        return "redirect:/";
    }

    //
    //  Remove Book
    @GetMapping(value = "/admin/books/delete/{bookId}")
    public String deleteBook(@PathVariable(value = "bookId") Integer bookId) {

//        if (bookId == null || bookId <= 0) {
//            throw new IllegalStateException("Book ID is required!");
//        }
//
//        // delete the game by id
//        bookService.deleteBook(bookId);

        //repo.delete(bookId);
        repo.delete(bookId);
        return "redirect:/";
    }

}

