package guru.springframework.spring5webapp.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@EntityScan("guru.springframework.spring5webapp.model")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    private String isbn;

    public Publisher getPublisher() {
        return publisher;
    }

    //private String publisher;
    @OneToOne
    private Publisher publisher;

    public Book(String title, String isbn, Publisher publisher) {
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
    }

    //defining join table on one side , specifying the join and inverse join columns
    @ManyToMany
    @JoinTable(name                 = "author_book",
               joinColumns          = @JoinColumn(name = "book_id"),
               inverseJoinColumns   =  @JoinColumn(name = "author_id"))
    private Set<Author> authors  = new HashSet<>();


    public Set<Author> getAuthors() {
        return authors;
    }

    public String getTitle() {
        return title;
    }


    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public long getId() {
        return id;
    }

    public Book(String title, String isbn, Publisher publisher, Set<Author> authors) {
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
        this.authors = authors;
    }

    public Book() {

    }
}

