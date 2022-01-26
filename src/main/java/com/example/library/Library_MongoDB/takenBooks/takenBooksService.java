package com.example.library.Library_MongoDB.takenBooks;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class takenBooksService {

	@Autowired
	takenBooksRepository takenBooksRepository;

	public List<takenBooks> getAllBooks() {
		// TODO Auto-generated method stub
		List<takenBooks> takenBooksList = new ArrayList<>();
		takenBooksRepository.findAll().forEach(takenBooksList::add);
		return takenBooksList;
	}

	public void addtakenBooks(takenBooks takenBooks) {
		// TODO Auto-generated method stub
		
		takenBooksRepository.save(takenBooks);
	}

	public Optional<takenBooks> takenBooksById(String id) {
		// TODO Auto-generated method stub
		return takenBooksRepository.findById(id);
		
	}
}
