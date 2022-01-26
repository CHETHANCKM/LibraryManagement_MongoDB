package com.example.library.Library_MongoDB.returnedBooks;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.Library_MongoDB.Book.BookRepository;

@Service
public class ReturnbookService {
	
	@Autowired
	private ReturnbookRepository returnbookRepository;

	public List<Returnbook> getAllReturedBooks() {
		// TODO Auto-generated method stub
		List <Returnbook> returnbooksList = new ArrayList<>();
		returnbookRepository.findAll().forEach(returnbooksList::add);
		return returnbooksList;
	}

	public void addReturnBook(Returnbook returnbook) {
		// TODO Auto-generated method stub
		returnbookRepository.save(returnbook);
	}

}
