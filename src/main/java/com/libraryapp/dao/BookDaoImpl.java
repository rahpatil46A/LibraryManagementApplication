package com.libraryapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.libraryapp.model.Book;

@Repository
public class BookDaoImpl implements BookDao{

	@Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Book> findAll() {
        return jdbcTemplate.query("SELECT * FROM book", new BeanPropertyRowMapper<>(Book.class));
    }

    @Override
    public Book findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM book WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Book.class));
    }

    @Override
    public void save(Book book) {
        jdbcTemplate.update("INSERT INTO books (title, author, category, image) VALUES (?, ?, ?, ?)", book.getTitle(), book.getAuthor(), book.getCategory(),book.getImage());
    }

    @Override
    public void update(Book book) {
        jdbcTemplate.update("UPDATE books SET title = ?, author = ?, category = ?, image = ? WHERE id = ?", book.getTitle(), book.getAuthor(), book.getCategory(), book.getImage(), book.getId());
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM book WHERE id=?", id);
    }

}
