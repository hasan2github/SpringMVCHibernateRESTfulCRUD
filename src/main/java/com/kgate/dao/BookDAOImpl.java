package com.kgate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kgate.model.Book;

@Repository
public class BookDAOImpl implements BookDAO {

	@Autowired
	private SessionFactory factory;

	@Override
	public long save(Book book) {
		factory.getCurrentSession().save(book);
		return book.getId();
	}

	@Override
	public Book getBookById(long id) {
		return factory.getCurrentSession().get(Book.class, id);
	}

	@Override
	public List<Book> getAllBook() {
		/*
		 * Query
		 * query=factory.getSessionFactory().openSession().createQuery("from Book");
		 * List<Book> books=query.list();
		 */
		List<Book> books = factory.getSessionFactory().openSession().createQuery("from Book").list();

		return books;
	}

	@Override
	public void update(long id, Book book) {
		Session session = factory.getCurrentSession();
		Book book2 = session.byId(Book.class).load(id);
		book2.setAuthor(book.getAuthor());
		book2.setTitle(book.getTitle());
	}

	@Override
	public void delete(long id) {
		Session session = factory.getCurrentSession();
		Book book = session.byId(Book.class).load(id);
		session.delete(book);
	}

}
