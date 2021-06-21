package com.api.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.dao.BookRepoistory;
import com.api.book.entities.Book;

@Component
public class BookService {
	
	@Autowired
	private BookRepoistory bookRepoistory;
	
	/*
	 * private static List<Book> list = new ArrayList<Book>();
	 * 
	 * static { list.add(new Book(1234, "Complete Java Reference" , "XYZ"));
	 * list.add(new Book(123, "Head first to java" , "ABC")); list.add(new Book(12,
	 * "Think in java" , "Sanjay")); }
	 */
	
	//get all Books
	
	public List<Book> getAllBooks(){
		
		List<Book> list =(List<Book>)this.bookRepoistory.findAll();
		
		return list;
	}
	
	//get single book by id
	
	public Book getBookById(int id) {
		 Book book = null;
		 try {
			// book = list.stream().filter(e -> e.getId() == id).findFirst().get();
			 
			 book=this.bookRepoistory.findById(id);
			 
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		 
		
		return book;
	}
	
	//add book in the list
	
	public Book addBook(Book b) {
		Book result = bookRepoistory.save(b);
		return result;
	}
	
	//delete book 
	public void deleteBook(int bid) {
	//list =	list.stream().filter(book -> book.getId()!=bid).collect(Collectors.toList());		
		
		bookRepoistory.deleteById(bid);
	}
	
	//update book
	public void updateBook(Book book , int bookId) {
		/*
		 * list = list.stream().map(b->{
		 * 
		 * if (b.getId() == bookId) {
		 * 
		 * b.setTitle(book.getTitle()); b.setAuther(book.getAuther()); }
		 * 
		 * return b;
		 * 
		 * }).collect(Collectors.toList());
		 */
		book.setId(bookId);
		
		bookRepoistory.save(book);
		
	}

}
