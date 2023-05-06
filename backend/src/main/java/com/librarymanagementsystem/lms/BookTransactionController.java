package com.librarymanagementsystem.lms;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BookTransactionController {
    private List<BookTransaction> transactions;

    public BookTransactionController() {
        transactions = new ArrayList<>();
    }

    public void addTransaction(int id, int bookId, int memberId, BookTransaction.TransactionType type) {
        LocalDateTime now = LocalDateTime.now();
        BookTransaction transaction = new BookTransaction(id, bookId, memberId, type, now);
        transactions.add(transaction);
    }

    public List<BookTransaction> getTransactions() {
        return transactions;
    }

    public List<BookTransaction> getTransactionsByBookId(int bookId) {
        List<BookTransaction> result = new ArrayList<>();
        for (BookTransaction transaction : transactions) {
            if (transaction.getBookId() == bookId) {
                result.add(transaction);
            }
        }
        return result;
    }

    public List<BookTransaction> getTransactionsByMemberId(int memberId) {
        List<BookTransaction> result = new ArrayList<>();
        for (BookTransaction transaction : transactions) {
            if (transaction.getMemberId() == memberId) {
                result.add(transaction);
            }
        }
        return result;
    }
}
