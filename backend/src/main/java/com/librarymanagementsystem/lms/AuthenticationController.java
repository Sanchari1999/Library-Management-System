package com.librarymanagementsystem.lms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    private MemberService memberService;
    private LibrarianService librarianService;

    @Autowired
    public AuthenticationController(MemberService memberService, LibrarianService librarianService) {
        this.memberService = memberService;
        this.librarianService = librarianService;
    }

    @PostMapping("/login/member")
    public String memberLogin(@RequestBody Member member) {
        Member foundMember = memberService.getMemberByUsername(member.getUsername());
        if (foundMember != null && foundMember.getPassword().equals(member.getPassword())) {
            return "Login successful";
        } else {
            return "Invalid username or password";
        }
    }

    @PostMapping("/login/librarian")
    public String librarianLogin(@RequestBody Librarian librarian) {
        Librarian foundLibrarian = librarianService.getLibrarianByUsername(librarian.getUsername());
        if (foundLibrarian != null && foundLibrarian.getPassword().equals(librarian.getPassword())) {
            return "Login successful";
        } else {
            return "Invalid username or password";
        }
    }

    @PostMapping("/signup/member")
    public String memberSignup(@RequestBody Member member) {
        if (memberService.getMemberByUsername(member.getUsername()) == null) {
            memberService.addMember(member);
            return "Signup successful";
        } else {
            return "Username already exists";
        }
    }

    @PostMapping("/signup/librarian")
    public String librarianSignup(@RequestBody Librarian librarian) {
        if (librarianService.getLibrarianByUsername(librarian.getUsername()) == null) {
            librarianService.addLibrarian(librarian);
            return "Signup successful";
        } else {
            return "Username already exists";
        }
    }
}
