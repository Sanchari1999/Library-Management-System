package com.librarymanagementsystem.lms;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import com.librarymanagementsystem.lms.Book.BookStatus;

public interface BookRepository extends MongoRepository<Book, Integer> {
    Book findById(int id);
    Book findByIsbn(String isbn);
    Book getById(int id);
    // void removeById(int id);


    List<Book> findByStatus(BookStatus status);
}
