package com.libraryapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libraryapp.dao.BookDao;
import com.libraryapp.model.Book;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public List<Book> getAllBooks() {
        return bookDao.findAll();
    }

    @Override
    public Book getBookById(int id) {
        return bookDao.findById(id);
    }

    @Override
    public void addBook(Book book) {
        bookDao.save(book);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.update(book);
    }

    @Override
    public void deleteBook(int id) {
        bookDao.delete(id);
    }
}
