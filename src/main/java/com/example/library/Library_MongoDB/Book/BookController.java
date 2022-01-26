package com.example.library.Library_MongoDB.Book;


import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.Library_MongoDB.Exception.ResourceNotFoundException;





@RestController
public class BookController {
	
	@Autowired
	BookService bookService;
	
	Logger log = LoggerFactory.getLogger(BookController.class);
	
	@RequestMapping(value="/books")
	public List<Book> getAllBooks() 
	{
		if (bookService.getAllBooks().isEmpty())
		{
		
			throw new ResourceNotFoundException("No Books found");
			
		}
		else 
		return bookService.getAllBooks();
	}
	
	@RequestMapping(value = "/books/{id}")
	public Book getBook(@PathVariable String id)
	{
		return bookService.getBook(id).orElseThrow(()-> new ResourceNotFoundException("Book ID "+id+" not found"));
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/books")
	public void addBooks(@RequestBody Book book)
	{
		Random random = new Random();
		String tempBookId = "ISBN"+String.valueOf(random.nextInt(99999));
		book.setBookRefId(tempBookId.replace("-", ""));
		
		log.debug("DEBUG: ");
		log.error("ERROR: ");
		log.info("INFO: New Book updated");
		bookService.addBook(book);
	}
	
	@RequestMapping(method= RequestMethod.PUT, value="/books/{id}")
	public void updateBook(@PathVariable String id, @RequestBody Book book)
	{
		bookService.updateBook(id, book);
		log.debug("DEBUG: ");
		log.error("ERROR: ");
		log.info("INFO: Book updated with id "+id);
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/books/{id}")
	public void deleteBook(@PathVariable String id)
	{
		log.debug("DEBUG: ");
		log.error("ERROR: ");
		log.info("INFO: Book dated with id "+id);
		
		bookService.deleteBook(id);
	}
	
	
}
