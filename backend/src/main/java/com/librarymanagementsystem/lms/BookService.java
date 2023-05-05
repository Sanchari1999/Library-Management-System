package com.librarymanagementsystem.lms;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;
import com.librarymanagementsystem.lms.Book.BookStatus;


@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Integer id) {
        return bookRepository.findById(id);
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public Optional<Book> updateBook(Integer id, Book book) {
        Optional<Book> existingBook = bookRepository.findById(id);
        if (existingBook.isPresent()) {
            Book updatedBook = existingBook.get();
            updatedBook.setTitle(book.getTitle());
            updatedBook.setAuthor(book.getAuthor());
            updatedBook.setIsbn(book.getIsbn());
            updatedBook.setStatus(book.getStatus());
            bookRepository.save(updatedBook);
            return Optional.of(updatedBook);
        } else {
            return Optional.empty();
        }
    }


    public Book createBook(Book book) {
        return bookRepository.save(book);
    }


    public boolean deleteBook(Integer id) {
        Optional<Book> existingBook = bookRepository.findById(id);
        if (existingBook.isPresent()) {
            bookRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }


    public List<Book> getAvailableBooks() {
        return bookRepository.findByStatus(BookStatus.AVAILABLE); // modify this line
    }

    public List<Book> getBorrowedBooks() {
        return bookRepository.findByStatus(BookStatus.BORROWED); // modify this line
    }

    public void borrowBook(Integer id) {
        Optional<Book> existingBook = bookRepository.findById(id);
        if (existingBook.isPresent()) {
            Book book = existingBook.get();
            book.setStatus(BookStatus.BORROWED);
            bookRepository.save(book);
        }
    }

    public void returnBook(Integer id) {
        Optional<Book> existingBook = bookRepository.findById(id);
        if (existingBook.isPresent()) {
            Book book = existingBook.get();
            book.setStatus(BookStatus.AVAILABLE);
            bookRepository.save(book);
        }
    }
}
