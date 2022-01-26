package com.example.library.Library_MongoDB.Customer;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "customers")
@EntityScan
public class Customer {

	@Id
	private String cRefId;
	@Field
	private String cName;
	@Field
	private boolean active;
	@Field
	private String customerType;
	@Field
	private String dateOfJoining;
	@Field
	private int takenCount;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String cRefId, String cName, boolean active, String customerType, String dateOfJoining,
			int takenCount) {
		super();
		this.cRefId = cRefId;
		this.cName = cName;
		this.active = active;
		this.customerType = customerType;
		this.dateOfJoining = dateOfJoining;
		this.takenCount = takenCount;
	}

	public String getcRefId() {
		return cRefId;
	}

	public void setcRefId(String cRefId) {
		this.cRefId = cRefId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public boolean active() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public int getTakenCount() {
		return takenCount;
	}

	public void setTakenCount(int takenCount) {
		this.takenCount = takenCount;
	}
	

}
