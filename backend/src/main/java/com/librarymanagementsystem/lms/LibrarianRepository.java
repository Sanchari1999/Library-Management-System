package com.librarymanagementsystem.lms;

import java.util.List;

public interface LibrarianRepository {
    void add(Librarian librarian);
    void update(Librarian librarian);
    void remove(int id);
    List<Librarian> getAllLibrarians();
    Librarian getById(int id);
    Librarian getByUsername(String username);
}
