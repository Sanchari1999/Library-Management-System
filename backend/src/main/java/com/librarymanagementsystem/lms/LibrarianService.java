package com.librarymanagementsystem.lms;

import java.util.List;

public class LibrarianService {
    private LibrarianRepository librarianRepository;

    public LibrarianService(LibrarianRepository librarianRepository) {
        this.librarianRepository = librarianRepository;
    }

    public void addLibrarian(Librarian librarian) {
        librarianRepository.add(librarian);
    }

    public void removeLibrarian(int id) {
        librarianRepository.remove(id);
    }

    public void updateLibrarian(Librarian librarian) {
        librarianRepository.update(librarian);
    }

    public List<Librarian> getAllLibrarians() {
        return librarianRepository.getAllLibrarians();
    }

    public Librarian getLibrarianByUsername(String username) {
        return librarianRepository.getByUsername(username);
    }

    public Librarian getLibrarianById(int id) {
        return librarianRepository.getById(id);
    }
}
