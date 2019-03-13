package com.kgate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kgate.model.Book;
import com.kgate.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/book", method = RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody Book book) {
		long id = bookService.save(book);
		return ResponseEntity.ok().body(" New Book has been saved with ID : " + id);

	}

	@RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
	public ResponseEntity<Book> get(@PathVariable("id") long id) {
		Book book = bookService.getBookById(id);
		return ResponseEntity.ok().body(book);
	}

	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public ResponseEntity<List<Book>> list() {
		List<Book> books = bookService.getAllBook();
		return ResponseEntity.ok().body(books);

	}

	@RequestMapping(value = "/book/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Book book) {
		bookService.update(id, book);
		return ResponseEntity.ok().body("Book has been updated successfully.");

	}

	@RequestMapping(value = "/book/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable("id") long id, @RequestBody Book book) {
		bookService.delete(id);
		return ResponseEntity.ok().body("Record deleted with ID : " + id);

	}
}
