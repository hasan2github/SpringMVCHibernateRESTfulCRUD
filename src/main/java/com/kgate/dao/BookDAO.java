package com.kgate.dao;

import java.util.List;

import com.kgate.model.Book;

public interface BookDAO {
	long save(Book book);

	Book getBookById(long id);

	List<Book> getAllBook();

	void update(long id, Book book);

	void delete(long id);
}
