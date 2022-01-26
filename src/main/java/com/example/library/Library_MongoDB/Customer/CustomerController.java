package com.example.library.Library_MongoDB.Customer;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	Logger log = LoggerFactory.getLogger(CustomerController.class);
	
	@RequestMapping(value ="/customers")
	public List<Customer> getAllCustomers()
	{
		return customerService.getAllCustomers();
		
	}
	
	@RequestMapping(value="/customers/{id}")
	public Optional<Customer> getCustomer(@PathVariable String id)
	{
		return customerService.getCustomer(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/customers")
	public void addCustomer(@RequestBody Customer customer)
	{
		String tempName = customer.getcName().substring(0,2).toUpperCase();
		String tempDate = customer.getDateOfJoining().replace("-", "");
		String tempRefNum = tempName+tempDate;
		customer.setcRefId(tempRefNum);
		customer.setTakenCount(0);
		customer.setActive(true);
		
		log.debug("DEBUG: ");
		log.error("ERROR: ");
		log.info("INFO: New Custumer updated");
		
		customerService.addCustomer(customer);
		
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/customers/{id}")
	public void updateCustomer(@PathVariable String id, @RequestBody Customer customer)
	{
		customerService.updateCustomer(id, customer);
		
		log.debug("DEBUG: ");
		log.error("ERROR: ");
		log.info("INFO: Customer updated with id "+id);
	}
	
	@RequestMapping(value = "/customer/{id}")
	public void deleteCustomer(@PathVariable String id)
	{
		customerService.deleteCustomer(id);
		log.debug("DEBUG: ");
		log.error("ERROR: ");
		log.info("INFO: Customer deleted with id "+id);
	}
	
	
	
}
