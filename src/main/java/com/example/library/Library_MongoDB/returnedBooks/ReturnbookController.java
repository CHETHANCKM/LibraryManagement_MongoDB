package com.example.library.Library_MongoDB.returnedBooks;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.Library_MongoDB.Book.Book;
import com.example.library.Library_MongoDB.Book.BookRepository;
import com.example.library.Library_MongoDB.Book.BookService;
import com.example.library.Library_MongoDB.Customer.Customer;
import com.example.library.Library_MongoDB.Customer.CustomerService;
import com.example.library.Library_MongoDB.takenBooks.takenBooks;
import com.example.library.Library_MongoDB.takenBooks.takenBooksRepository;
import com.example.library.Library_MongoDB.takenBooks.takenBooksService;

@RestController
public class ReturnbookController {

	@Autowired
	private ReturnbookService returnbookService;
	@Autowired
	private takenBooksService takenBooksService;
	
	@Autowired
	private CustomerService customerService; 
	
	@Autowired
	private BookService bookService;
	
	
	Logger log = LoggerFactory.getLogger(ReturnbookController.class);
	
	@RequestMapping(value="/returnedbooks")
	public List<Returnbook> getAllReturnedBooks()
	{
		return returnbookService.getAllReturedBooks();
	}

	
	@RequestMapping(method = RequestMethod.POST, value="/returnedbooks/{refid}")
	public void addReturnBook(@PathVariable String refid, @RequestBody Returnbook returnbook)
	{
		
		Optional<takenBooks> takenBooks=  takenBooksService.takenBooksById(refid);
		
		
		returnbook.setReturnId(refid);
		
		returnbook.setBookId(takenBooks.get().getBookId());
		
		returnbook.setBookName(takenBooks.get().getBookName());
		returnbook.setcId(takenBooks.get().getCustId());
		returnbook.setcName(takenBooks.get().getCustName());
		returnbook.setDueDate(takenBooks.get().getBookEndDate());
		
		
		Optional<Book> book = bookService.getBook(takenBooks.get().getBookId());
		int bookCount = book.get().getBookCount()+1;
		
		book.get().setBookCount(bookCount);
		
		Optional<Customer> custObject = customerService.getCustomer(takenBooks.get().getCustId());
		
		int takenCount =custObject.get().getTakenCount()-1;
		custObject.get().setTakenCount(takenCount);
		
		if(book.get().getBookCount()==1)
		{
			book.get().setBookStatus("available");
			
			
			
			log.debug("DEBUG: ");
			log.error("ERROR: ");
			log.info("INFO: Book stocks status updated to available");
		}
		else{
			
			
			
			log.debug("DEBUG: ");
			log.error("ERROR: ");
			log.info("INFO: New Return Book added");
		}
		
		bookService.addBook(book.get());
		customerService.addCustomer(custObject.get());
		returnbookService.addReturnBook(returnbook);
	}
	
}
