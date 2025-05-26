package com.libraryapp.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.libraryapp.dao.BookDao;
import com.libraryapp.model.Book;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public void addBook(Book book, MultipartFile imageFile) throws IOException {
    	try {
    	
        if (imageFile != null && !imageFile.isEmpty()) {
            book.setImage(imageFile.getBytes());
        }
        System.out.println(book);
        bookDao.save(book);
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
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
