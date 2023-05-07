package com.librarymanagementsystem.lms;

import java.util.List;
import java.util.Optional;


public class MemberService {
    private MemberRepository memberRepository;
    private BookTransactionService transactionService;
    private BookService bookService;

    public MemberService(MemberRepository memberRepository, BookTransactionService transactionService, BookService bookService) {
        this.memberRepository = memberRepository;
        this.transactionService = transactionService;
        this.bookService = bookService;
    }

    public void registerMember(Member member) {
        memberRepository.add(member);
    }

    public void deleteMember(int id) {
        memberRepository.remove(id);
    }

    public void updateMember(Member member) {
        memberRepository.update(member);
    }

    public List<Member> getAllMembers() {
        return memberRepository.getAllMembers();
    }

    public Member getMemberById(int id) {
        return memberRepository.getMemberById(id);
    }

    public void addMember(Member member) {
        memberRepository.add(member);
    }

    public boolean removeMember(Integer id) {
        Optional<Member> existingMember = memberRepository.findByIdOptional(id);
        if (existingMember.isPresent()) {
            memberRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }




    public void borrowBook(int bookId, int memberId) {
        // check if book is available
        Book book = bookService.getBookById(bookId);
        if (book.getQuantityAvailable() == 0) {
            throw new RuntimeException("Book is not available for borrowing");
        }

        // check if member has already borrowed the book
        if (transactionService.isBookAlreadyBorrowed(bookId, memberId)) {
            throw new RuntimeException("Member has already borrowed this book");
        }

        // borrow the book
        transactionService.borrowBook(bookId, memberId);
        bookService.decreaseBookQuantity(bookId);
    }

    public void returnBook(int bookId, int memberId) {
        // check if member has borrowed the book
        if (!transactionService.isBookAlreadyBorrowed(bookId, memberId)) {
            throw new RuntimeException("Member has not borrowed this book");
        }

        // return the book
        transactionService.returnBook(bookId, memberId);
        bookService.increaseBookQuantity(bookId);
    }

    public List<Book> getAllAvailableBooks() {
        return bookService.getAllAvailableBooks();
    }

    public Member getMemberByUsername(String username) {
        return memberRepository.getMemberByUsername(username);
    }

}
