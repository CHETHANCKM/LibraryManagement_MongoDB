package com.example.library.Library_MongoDB.takenBooks;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.Library_MongoDB.Book.Book;
import com.example.library.Library_MongoDB.Book.BookService;
import com.example.library.Library_MongoDB.Customer.Customer;
import com.example.library.Library_MongoDB.Customer.CustomerService;
import com.example.library.Library_MongoDB.Exception.ResourceNotFoundException;

@RestController
public class takenBooksController {

	@Autowired
	private takenBooksService takenBooksService;
	@Autowired
	private BookService bookService;
	@Autowired
	private CustomerService customerService;

	Logger log = LoggerFactory.getLogger(takenBooksController.class);

	@RequestMapping(value = "/takenbooks")
	public List<takenBooks> getAllBooks() {
		return takenBooksService.getAllBooks();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/takenbooks/{custID}")
	public void addtakenBooks(@PathVariable String custID, @RequestBody takenBooks takenBooks) {
		Random random = new Random();
		int ReferenceNumber = random.nextInt(99999);
		takenBooks.setReferenceId(String.valueOf(ReferenceNumber));

		String startDate = takenBooks.getBooktStartDate();
		LocalDate date = LocalDate.parse(startDate);
		LocalDate endDate = date.plusDays(7);
		takenBooks.setBookEndDate(String.valueOf(endDate));

		Optional<Book> bookObject = bookService.BookObject(takenBooks.getBookId());
		int bookCount = bookObject.get().getBookCount() - 1;
		bookObject.get().setBookCount(bookCount);

		Optional<Customer> custObject = customerService.getCustomer(custID);

		takenBooks.setCustId(custID);
		takenBooks.setCustName(custObject.get().getcName());
		takenBooks.setBookName(bookObject.get().getBooktitle());

		int takenCount = custObject.get().getTakenCount()+1;
		
		custObject.get().setTakenCount(takenCount);
		
		if (bookCount < 0) {
			throw new ResourceNotFoundException("No stock available");
		} 
		else 
		{
			if (bookCount == 0) {
				bookObject.get().setBookStatus("not available");
				log.info("INFO: No stocks of books updated");
			}
			
			customerService.updateCustomer(custID, custObject.get());
			bookService.updateBook(custID, bookObject.get());
			takenBooksService.addtakenBooks(takenBooks);
		}

		log.debug("DEBUG: ");
		log.error("ERROR: ");
		log.info("INFO: New Taken Book added");
	}

	@RequestMapping(value = "/takenbooks/{refid}")
	public Optional<takenBooks> takenBooksById(@PathVariable String refid) {
		return takenBooksService.takenBooksById(refid);
	}

}
