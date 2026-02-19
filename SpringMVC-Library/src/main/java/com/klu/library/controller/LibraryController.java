package com.klu.library.controller;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klu.library.model.Book;

@RestController
public class LibraryController {
	
	    private List<Book> bookList = new ArrayList<>();

	    // 2. /welcome
	    @GetMapping("/welcome")
	    public String welcome() {
	        return "Welcome to the Online Library System";
	    }

	    // 3. /count
	    @GetMapping("/count")
	    public int totalBooks() {
	        return 120;
	    }

	    // 4. /price
	    @GetMapping("/price")
	    public double bookPrice() {
	        return 499.99;
	    }

	    // 5. /books
	    @GetMapping("/books")
	    public List<String> getBookTitles() {
	        return Arrays.asList(
	                "Full Stack",
	                "C Programming ",
	                "Java Programming ",
	                "Computer Networks"
	        );
	    }

	    // 6. /books/{id}
	    @GetMapping("/books/{id}")
	    public String getBookById(@PathVariable int id) {
	        return "Details of book with ID: " + id;
	    }

	    // 7. /search?title=
	    @GetMapping("/search")
	    public String searchBook(@RequestParam String title) {
	        return "Search completed for book title: " + title;
	    }

	    // 8. /author/{name}
	    @GetMapping("/author/{name}")
	    public String getAuthor(@PathVariable String name) {
	        return "Books written by author: " + name;
	    }
	    
	    @PostMapping("/addbook")
	    public String addBook(@RequestBody Book book) {
	        bookList.add(book);
	        return "Book added successfully: " + book.getTitle();
	    }

	    // 10. /viewbooks (GET)
	    @GetMapping("/viewbooks")
	    public List<Book> viewBooks() {
	        return bookList;
	    }

}
