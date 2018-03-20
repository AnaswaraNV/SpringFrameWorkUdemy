package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.Repository.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model) {
        //list of authors fetched from database
        model.addAttribute("authors", authorRepository.findAll());

        return "authors";
    }

}
