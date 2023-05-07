package com.librarymanagementsystem.lms;

import java.time.LocalDateTime;
import java.util.List;

public interface BookTransactionRepository {

    void add(BookTransaction transaction);

    void remove(BookTransaction transaction);

    List<BookTransaction> getAllTransactions();

    List<BookTransaction> getTransactionsByBookId(int bookId);

    List<BookTransaction> getTransactionsByMemberId(int memberId);

    List<BookTransaction> getTransactionsByType(BookTransaction.TransactionType type);

    List<BookTransaction> getTransactionsByDateRange(LocalDateTime start, LocalDateTime end);

}
