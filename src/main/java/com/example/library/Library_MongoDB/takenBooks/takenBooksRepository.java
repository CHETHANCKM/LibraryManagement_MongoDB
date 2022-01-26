package com.example.library.Library_MongoDB.takenBooks;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface takenBooksRepository extends MongoRepository<takenBooks, String> {

	
	
}
