package com.librarymanagementsystem.lms;

public class LibrarianController {
    private BookService bookService;
    private MemberService memberService;
    private BookTransactionService transactionService;

    public LibrarianController(BookService bookService, MemberService memberService, BookTransactionService transactionService) {
        this.bookService = bookService;
        this.memberService = memberService;
        this.transactionService = transactionService;
    }

    public void addBook(Book book) {
        bookService.addBook(book);
    }

    public void removeBook(int bookId) {
        bookService.removeBook(bookId);
    }

    public void addMember(Member member) {
        memberService.addMember(member);
    }

    public void removeMember(int memberId) {
        memberService.removeMember(memberId);
    }

    public void borrowBook(int bookId, int memberId) {
        transactionService.borrowBook(bookId, memberId);
    }

    public void returnBook(int bookId, int memberId) {
        transactionService.returnBook(bookId, memberId);
    }
}
