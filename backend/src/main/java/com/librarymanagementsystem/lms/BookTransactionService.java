package com.librarymanagementsystem.lms;

import java.time.LocalDateTime;
import java.util.List;

public class BookTransactionService {

    private BookTransactionRepository bookTransactionRepository;

    public BookTransactionService(BookTransactionRepository bookTransactionRepository) {
        this.bookTransactionRepository = bookTransactionRepository;
    }

    public void addBookTransaction(BookTransaction bookTransaction) {
        bookTransactionRepository.add(bookTransaction);
    }

    public void removeBookTransaction(BookTransaction bookTransaction) {
        bookTransactionRepository.remove(bookTransaction);
    }



    public List<BookTransaction> getAllBookTransactions() {
        return bookTransactionRepository.getAllTransactions();
    }

    public List<BookTransaction> getBookTransactionsByBookId(int bookId) {
        return bookTransactionRepository.getTransactionsByBookId(bookId);
    }

    public List<BookTransaction> getBookTransactionsByMemberId(int memberId) {
        return bookTransactionRepository.getTransactionsByMemberId(memberId);
    }

    public List<BookTransaction> getBookTransactionsByDateRange(LocalDateTime start, LocalDateTime end) {
        return bookTransactionRepository.getTransactionsByDateRange(start, end);
    }
}
