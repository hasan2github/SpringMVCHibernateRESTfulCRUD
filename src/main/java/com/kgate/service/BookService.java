package com.kgate.service;

import java.util.List;

import com.kgate.model.Book;

public interface BookService {
	long save(Book book);

	Book getBookById(long id);

	List<Book> getAllBook();

	void update(long id, Book book);

	void delete(long id);
}
