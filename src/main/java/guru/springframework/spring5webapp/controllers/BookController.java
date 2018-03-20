package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.Repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private BookRepository bookRepository;

   public BookController(BookRepository bookRepository) {
       this.bookRepository = bookRepository;
   }


    //by passing model, spring wil pass implementation at run time
    //in web app, whenever url comes to /books getbooks will be called
    @RequestMapping("/books")
    public String getBooks(Model model) {
       //list of books will be fetched from database
        model.addAttribute("books" , bookRepository.findAll());
        //giving view name
        return "books";
    }

}
