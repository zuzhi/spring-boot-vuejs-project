package com.zuzhi.springbootvuejsproject.book;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * BookService
 *
 * @author zuzhi
 * @date 13/03/2018
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    Book findBookById(Long bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException("Book not found. ID: " + bookId));
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    Book createBook(Book book) {
        final Book newBook = new Book();
        newBook.setTitle(book.getTitle());
        newBook.setAuthor(book.getAuthor());
        return bookRepository.save(newBook);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    Book updateBook(Book book, Long bookId) {
        Preconditions.checkNotNull(book);
        Preconditions.checkState(book.getId().equals(bookId));
        Preconditions.checkNotNull(bookRepository.findById(bookId));
        return bookRepository.save(book);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    Book updateBook(Map<String, String> updates, Long bookId) {
        final Book book = findBookById(bookId);
        updates.keySet()
                .forEach(key -> {
                    switch (key) {
                        case "author":
                            book.setAuthor(updates.get(key));
                            break;
                        case "title":
                            book.setTitle(updates.get(key));
                            break;
                        default:
                            break;
                    }
                });
        return bookRepository.save(book);
    }
}
