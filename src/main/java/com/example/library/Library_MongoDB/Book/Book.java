package com.example.library.Library_MongoDB.Book;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "books")
@EntityScan
public class Book {
	@Id
	private String bookRefId;
	@Field
	private String booktitle;
	@Field
	private String bookAuthor;
	@Field
	private String publishDate;
	@Field
	private double bookPrice;
	@Field
	private String bookStatus;
	@Field
	private int bookCount;
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(String bookRefId, String booktitle, String bookAuthor, String publishDate, double bookPrice,
			String bookStatus, int bookCount) {
		super();
		this.bookRefId = bookRefId;
		this.booktitle = booktitle;
		this.bookAuthor = bookAuthor;
		this.publishDate = publishDate;
		this.bookPrice = bookPrice;
		this.bookStatus = bookStatus;
		this.bookCount = bookCount;
	}
	
	public String getBookRefId() {
		return bookRefId;
	}
	public void setBookRefId(String bookRefId) {
		this.bookRefId = bookRefId;
	}
	public String getBooktitle() {
		return booktitle;
	}
	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	public double getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
	public String getBookStatus() {
		return bookStatus;
	}
	public void setBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}
	public int getBookCount() {
		return bookCount;
	}
	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}

}
