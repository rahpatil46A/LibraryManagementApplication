package com.libraryapp.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.libraryapp.dao.BookDao;
import com.libraryapp.model.Book;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public void addBook(Book book, MultipartFile imageFile) throws IOException {
    	System.out.println(book);
    	if(imageFile!=null) {
    		System.out.println("Hello");
    	}
        if (imageFile != null && !imageFile.isEmpty()) {
            book.setImage(imageFile.getBytes());
        }
        bookDao.save(book);
    }

    // Update book with image
    @Override
    public void updateBook(Book book, MultipartFile imageFile) throws IOException {
        if (imageFile != null && !imageFile.isEmpty()) {
            book.setImage(imageFile.getBytes());
        }
        
        bookDao.update(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDao.findAll();
    }

    @Override
    public Book getBookById(int id) {
        return bookDao.findById(id);
    }

    @Override
    public void deleteBook(int id) {
        bookDao.delete(id);
    }
}
