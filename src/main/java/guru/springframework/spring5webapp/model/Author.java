package guru.springframework.spring5webapp.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@EntityScan("guru.springframework.spring5webapp.model")

public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;

    //target site - authors is the hash set defined in book class
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



}
