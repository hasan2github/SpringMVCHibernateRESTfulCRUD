package com.kgate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kgate.dao.BookDAO;
import com.kgate.model.Book;

@Service
@Transactional(readOnly = true)
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDAO bookDAO;

	@Override
	@Transactional
	public long save(Book book) {
		return bookDAO.save(book);
	}

	@Override
	public Book getBookById(long id) {
		return bookDAO.getBookById(id);
	}

	@Override
	public List<Book> getAllBook() {
		return bookDAO.getAllBook();
	}

	@Override
	@Transactional
	public void update(long id, Book book) {
		bookDAO.update(id, book);

	}

	@Override
	@Transactional
	public void delete(long id) {
		bookDAO.delete(id);
		
	}

}
