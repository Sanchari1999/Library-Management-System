package com.librarymanagementsystem.lms;

import java.util.List;

public class MemberController {
    private BookService bookService;
    private MemberService memberService;
    private BookTransactionService transactionService;

    public MemberController(BookService bookService, MemberService memberService, BookTransactionService transactionService) {
        this.bookService = bookService;
        this.memberService = memberService;
        this.transactionService = transactionService;
    }

    public List<Book> viewAvailableBooks() {
        return bookService.getAvailableBooks();
    }

    public void borrowBook(int bookId, int memberId) {
        transactionService.borrowBook(bookId, memberId);
    }

    public void returnBook(int bookId, int memberId) {
        transactionService.returnBook(bookId, memberId);
    }

    public void deleteMember(int memberId) {
        memberService.removeMember(memberId);
    }
}
