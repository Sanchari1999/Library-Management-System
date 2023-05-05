package com.librarymanagementsystem.lms;

import java.time.LocalDateTime;


public class BookTransaction {
    private int id;
    private int book_id;
    private int member_id;
    private TransactionType transaction_type;
    private LocalDateTime transaction_date;

    public BookTransaction(int id, int book_id, int member_id, TransactionType transaction_type, LocalDateTime transaction_date) {
        this.id = id;
        this.book_id = book_id;
        this.member_id = member_id;
        this.transaction_type = transaction_type;
        this.transaction_date = transaction_date;
    }

    public int getId() {
        return id;
    }

    public int getBookId() {
        return book_id;
    }

    public int getMemberId() {
        return member_id;
    }

    public TransactionType getTransactionType() {
        return transaction_type;
    }

    public LocalDateTime getTransactionDate() {
        return transaction_date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBookId(int book_id) {
        this.book_id = book_id;
    }

    public void setMemberId(int member_id) {
        this.member_id = member_id;
    }

    public void setTransactionType(TransactionType transaction_type) {
        this.transaction_type = transaction_type;
    }

    public void setTransactionDate(LocalDateTime transaction_date) {
        this.transaction_date = transaction_date;
    }

    public enum TransactionType {
        BORROW,
        RETURN
    }


}
