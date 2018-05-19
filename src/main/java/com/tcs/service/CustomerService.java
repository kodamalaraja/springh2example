package com.tcs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.tcs.bean.Customer;
import com.tcs.repository.CustomerRepository;



@Service
public class CustomerService {
	@Autowired
	CustomerRepository repository;
	
	public String process() {
		repository.save(new Customer("Jack", "Smith"));
		repository.save(new Customer("Adam", "Johnson"));
		repository.save(new Customer("Kim", "Smith"));
		repository.save(new Customer("David", "Williams"));
		repository.save(new Customer("Peter", "Davis"));
		return "Done";
	}
	
	public Iterable<Customer> findAll() {
		Iterable<Customer> result;

		result = repository.findAll();

		return result;
	}
	
	
	public Customer findById(long id) {
		Customer result;
		result = repository.findById(id).get();
		return result;
	}
	
	public Customer saveData(Customer customer) {
		Customer c=repository.save(customer);
		return c;
	}
	
	public Customer updateCustomer(long id, Customer customer) {
		Customer result;
		result = repository.findById(id).get();
		result.setFirstName(customer.getFirstName());
		result.setLastName(customer.getLastName());
		result = repository.save(result);
		return result;
	}
	
	
	public String delete( long id) {
		String out="Done";
		repository.deleteById(id);
		return out;
	}
	
	
}
