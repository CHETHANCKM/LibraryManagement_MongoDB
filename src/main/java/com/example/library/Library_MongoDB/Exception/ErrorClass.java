package com.example.library.Library_MongoDB.Exception;

import java.sql.Date;

public class ErrorClass {

	private Date date;
	private String message;
	private String details;
	public ErrorClass() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ErrorClass(Date date, String message, String details) {
		super();
		this.date = date;
		this.message = message;
		this.details = details;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	
	
	
}
