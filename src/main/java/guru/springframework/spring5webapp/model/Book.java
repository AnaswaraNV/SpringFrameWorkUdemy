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
    private String isbn;
    private String publisher;

    //defining join table on one side , specifying the join and inverse join columns
    @ManyToMany
    @JoinTable(name                 = "author_book",
               joinColumns          = @JoinColumn(name = "book_id"),
               inverseJoinColumns   =  @JoinColumn(name = "author_id"))
    private Set<Author> authors  = new HashSet<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }



}

