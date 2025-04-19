package com.libraryapp.dao;

import java.util.List;

import com.libraryapp.model.Book;

public interface BookDao {
    List<Book> findAll();
    Book findById(int id);
    void save(Book book);
    void update(Book book);
    void delete(int id);
}

