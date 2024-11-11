package com.ebere.bookcatalog.controller;

import com.ebere.bookcatalog.model.Book;
import com.ebere.bookcatalog.service.ManagementServiceClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import javax.annotation.PreDestroy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Slf4j
@RequiredArgsConstructor
@Controller
public class BookController {

    private final ManagementServiceClient managementServiceClient;


    @GetMapping("")
    public String getHomePage(Model model) {
        return "homePage";
    }

    @GetMapping("/book/form/new")
    public String showBookForm(Model model) {
        model.addAttribute("book", new Book());
        System.out.println("Im in books");
        return "bookForm";
    }




    @GetMapping("/books")
    public String getBooks(Model model) {

        List<Book> books = managementServiceClient.getAllBooks();
        log.info("Books found: {}", books);
        model.addAttribute("books", books);
        log.info("Next line");
        return "bookList";
    }



    @GetMapping("/book/{id}")
    public String getBook(@PathVariable("id") int id, Model model) {
        Book book = managementServiceClient.getBookById(id);
        model.addAttribute("book", book);
        return "bookDetails";
    }

    @PostMapping("/book/save")
    public String saveBook(@ModelAttribute Book book) {
        if (book.getId() == null) {
            managementServiceClient.addBook(book);
        } else {
            managementServiceClient.updateBook(book.getId(), book);
        }
        return "redirect:/books";
    }

    @GetMapping("/book/update/{id}")
    public String showEditBookForm(@PathVariable("id") int id, Model model) {
        Book book = managementServiceClient.getBookById(id);
        model.addAttribute("book", book);
        return "bookForm";
    }

    @PostMapping("/book/delete/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        managementServiceClient.deleteBook(id);
        return "redirect:/books";
    }

    @PreDestroy
    public void cleanup() {
        managementServiceClient.close();
    }
}

