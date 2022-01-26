package com.example.library.Library_MongoDB.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.Library_MongoDB.Exception.ResourceNotFoundException;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		List<Customer> customerList = new ArrayList<>();
		customerRepository.findAll().forEach(customerList::add);
		return customerList;
	}

	public void addCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	public void deleteCustomer(String id) {
		// TODO Auto-generated method stub
		customerRepository.deleteById(id);
	}

	public Optional<Customer> getCustomer(String id) {
		// TODO Auto-generated method stub
		return customerRepository.findById(id);
	}

	

	public void updateCustomer(String id, Customer customer) {
		// TODO Auto-generated method stub
		customerRepository.save(customer);
	}

}
