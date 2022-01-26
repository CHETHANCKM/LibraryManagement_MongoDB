package com.example.library.Library_MongoDB.returnedBooks;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "returnBook")
@EntityScan
public class Returnbook {
	
	@Id
	String returnId;
	String bookId;
	String bookName;
	String cId;
	String cName;
	String dueDate;
	String submittedDate;
	public Returnbook() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Returnbook(String returnId, String bookId, String bookName, String cId, String cName, String dueDate,
			String submittedDate) {
		super();
		this.returnId = returnId;
		this.bookId = bookId;
		this.bookName = bookName;
		this.cId = cId;
		this.cName = cName;
		this.dueDate = dueDate;
		this.submittedDate = submittedDate;
	}


	public String getReturnId() {
		return returnId;
	}
	public void setReturnId(String returnId) {
		this.returnId = returnId;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getcId() {
		return cId;
	}
	public void setcId(String cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public String getSubmittedDate() {
		return submittedDate;
	}
	public void setSubmittedDate(String submittedDate) {
		this.submittedDate = submittedDate;
	}
	

	
}
