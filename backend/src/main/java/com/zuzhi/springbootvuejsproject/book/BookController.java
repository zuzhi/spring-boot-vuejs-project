package com.zuzhi.springbootvuejsproject.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * BookController
 *
 * @author zuzhi
 * @date 13/03/2018
 */
@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> findAllBooks() {
        return bookService.findAllBooks();
    }

    @GetMapping("/{bookId}")
    public Book findBookById(@PathVariable Long bookId) {
        return bookService.findBookById(bookId);
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @DeleteMapping("/{bookId}")
    public void deleteBook(@PathVariable Long bookId) {
        bookService.deleteBook(bookId);
    }

    @PutMapping("/{bookId}")
    public Book updateBook(@RequestBody Book book, @PathVariable Long bookId) {
        return bookService.updateBook(book, bookId);
    }

    @PatchMapping("/{bookId}")
    public Book updateBook(@RequestBody Map<String, String> updates, @PathVariable Long bookId) {
        return bookService.updateBook(updates, bookId);
    }
}
