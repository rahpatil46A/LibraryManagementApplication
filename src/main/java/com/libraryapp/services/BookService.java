package com.libraryapp.services;

import java.util.List;

import com.libraryapp.model.Book;

public interface BookService {
    List<Book> getAllBooks();
    Book getBookById(int id);
    void addBook(Book book);
    void updateBook(Book book);
    void deleteBook(int id);
}