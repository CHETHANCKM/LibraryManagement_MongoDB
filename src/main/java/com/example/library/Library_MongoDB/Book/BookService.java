package com.example.library.Library_MongoDB.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	
	@Autowired
	BookRepository bookRepository;

	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		List<Book> bookList = new ArrayList<>();
		bookRepository.findAll().forEach(bookList::add);
		return bookList;
	}


	public void addBook(Book book) {
		bookRepository.save(book);
		
	}

	
	public Optional<Book> getBook(String id) {
		// TODO Auto-generated method stub
		return bookRepository.findById(id);
		 
	}


	public void deleteBook(String id) {
		// TODO Auto-generated method stub
		bookRepository.deleteById(id);
	}


	public void updateBook(String id, Book book) {
		// TODO Auto-generated method stub
		bookRepository.save(book);
	}


	public Optional<Book> BookObject(String bookId) {
		// TODO Auto-generated method stub
		
		return bookRepository.findById(bookId);
		
	}


	
	
	

}
