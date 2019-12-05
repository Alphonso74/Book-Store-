package mobyDickensBookStore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sun.security.x509.X509CertInfo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
@Table(name = "Book")
public class Book {

    /*
        Instance Data
     */

    protected Book() {
    }

    @Id
    @Column(name = "id")
    private Integer bookID;

    @Column(name = "title")
    private String title;


    @Column(name = "isbn")
    private Long ISBN;

    @Column(name = "author")
    private String author;

    @Column(name = "year")
    private Integer datePublished;


    @Column(name = "price")
    private Double bookPrice;

    @Column(name = "genre")
    private  String genre;


    public Book(Integer bookId, String title, Long isbn, String author, Integer datePublished, Double bookPrice, String genre) {

        this.bookID = bookId;
        this.title = title;
        this.ISBN = isbn;
        this.author = author;
        this.datePublished = datePublished;
        this.bookPrice = bookPrice;
        this.genre = String.valueOf(genre);
    }


    public Integer getBookID() {
        return bookID;
    }

    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getISBN() {
        return ISBN;
    }

    public void setISBN(Long ISBN) {
        this.ISBN = ISBN;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(Integer datePublished) {
        this.datePublished = datePublished;
    }

    public Double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = String.valueOf(genre);
    }

    @Override
    public String toString() {
        return String.format("Book[id=%d, title='%s', isbn=%d, author='%s', year=%d, price= %d, genre='%s']", bookID, title, ISBN, author, datePublished,bookPrice,genre);
    }
}
