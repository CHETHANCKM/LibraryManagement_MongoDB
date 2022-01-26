package com.example.library.Library_MongoDB.takenBooks;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "takenBooks")
@EntityScan
public class takenBooks {
	
	@Id
	String referenceId;
	@Field
	String custId;
	@Field
	String custName;
	@Field
	String bookId;
	@Field
	String bookName;
	@Field
	String booktStartDate;
	@Field
	String bookEndDate;
	
	public takenBooks() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public takenBooks(String referenceId, String custId, String custName, String bookId, String bookName,
			String booktStartDate, String bookEndDate) {
		super();
		this.referenceId = referenceId;
		this.custId = custId;
		this.custName = custName;
		this.bookId = bookId;
		this.bookName = bookName;
		this.booktStartDate = booktStartDate;
		this.bookEndDate = bookEndDate;
	}



	public String getReferenceId() {
		return referenceId;
	}
	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
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
	public String getBooktStartDate() {
		return booktStartDate;
	}
	public void setBooktStartDate(String booktStartDate) {
		this.booktStartDate = booktStartDate;
	}
	public String getBookEndDate() {
		return bookEndDate;
	}
	public void setBookEndDate(String bookEndDate) {
		this.bookEndDate = bookEndDate;
	}
	
	
	
	
	
}
