package com.libraryapp.services;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.libraryapp.model.Book;

public interface BookService {
    List<Book> getAllBooks();
    Book getBookById(int id);
    void addBook(Book book,MultipartFile imageFile) throws IOException;
    void updateBook(Book book,MultipartFile imageFile)throws IOException;
    void deleteBook(int id);
}