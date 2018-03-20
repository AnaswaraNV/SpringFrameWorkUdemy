package guru.springframework.spring5webapp.BootStrap;

import guru.springframework.spring5webapp.Repository.AuthorRepository;
import guru.springframework.spring5webapp.Repository.BookRepository;
import guru.springframework.spring5webapp.Repository.PublisherRepository;
import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent>{

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

//auto injection
    public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {


        //author 1 , book1
        Author JKRowling = new Author("JK", "Rowling");
        Publisher publisher = new Publisher("Wonder Books" , "67 coco street");
        publisherRepository.save(publisher);
        Book harrypotter = new Book("Harry potter", "AB2421", publisher);
        JKRowling.getBooks().add(harrypotter);
        harrypotter.getAuthors().add(JKRowling);
        harrypotter.setPublisher(publisher);

        authorRepository.save(JKRowling);
        bookRepository.save(harrypotter);


        //author2, book2
        Author ConanDoyal = new Author("Arthur", "Doyel");
        Publisher publisher2 = new Publisher("Dream Works" , "7 yonge street");
        publisherRepository.save(publisher2);
        Book SherlockHolmes = new Book("Adventures of SherlockHolmes", "DF3223", publisher2);
        ConanDoyal.getBooks().add(SherlockHolmes);
        SherlockHolmes.getAuthors().add(ConanDoyal);
        SherlockHolmes.setPublisher(publisher2);

        authorRepository.save(ConanDoyal);
        bookRepository.save(SherlockHolmes);

    }

}
