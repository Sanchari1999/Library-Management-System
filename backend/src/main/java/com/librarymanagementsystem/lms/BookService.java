package com.librarymanagementsystem.lms;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
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

    public boolean removeBook(Integer id) {
        Optional<Book> existingBook = bookRepository.findById(id);
        if (existingBook.isPresent()) {
            bookRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public List<Book> getAvailableBooks() {
        return bookRepository.findByStatus(BookStatus.AVAILABLE);
    }

    public List<Book> getBorrowedBooks() {
        return bookRepository.findByStatus(BookStatus.BORROWED);
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

    public boolean deleteBook(int id) {
        Optional<Book> existingBook = bookRepository.findById(id);
        if (existingBook.isPresent()) {
            bookRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public List<Book> getAllAvailableBooks() {
        List<Book> allBooks = bookRepository.findAll();
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : allBooks) {
            if (book.getQuantityAvailable() > 0) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    public void increaseBookQuantity(int bookId) {
        Optional<Book> existingBook = bookRepository.findById(bookId);
        if (existingBook.isPresent()) {
            Book book = existingBook.get();
            int newQuantity = book.getQuantityAvailable() + 1;
            book.setQuantityAvailable(newQuantity);
            bookRepository.save(book);
        } else {
            throw new RuntimeException("Book not found");
        }
    }


}
