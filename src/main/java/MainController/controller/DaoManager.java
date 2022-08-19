package MainController.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import Model.Book;


@Component
public class DaoManager {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	
	@Transactional
	public String createBook(Book book) {
		
		this.hibernateTemplate.save(book);
		return "ligma";
	}
	
	public String getBooks(){
		List<Book> bookList = this.hibernateTemplate.loadAll(Book.class);
		
		
		return "";
	}
	
	@Transactional
	public String editBooks(Book book) {
		this.hibernateTemplate.saveOrUpdate(book);;
		return "successs";
	}
	
	@Transactional
	public Book deleteBook(int pid ) {
		Book book = loadSingle(pid);
		this.hibernateTemplate.delete(book);
//		this.hibernateTemplate.delete(book);
		return book;
	}

	public Book loadSingle(int pid) {
		// TODO Auto-generated method stub
		Book book = (Book)this.hibernateTemplate.load(Book.class, pid);
		return book;
		
	}
}
