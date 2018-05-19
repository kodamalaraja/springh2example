package com.tcs.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.bean.Customer;
import com.tcs.repository.CustomerRepository;
import com.tcs.service.CustomerService;

@CrossOrigin
@RestController
public class CustomerController {
	@Autowired
	CustomerService service;

	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public String process() {
		String out=service.process();
		return out;
	}

	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public Iterable<Customer> findAll() {
		Iterable<Customer> result;
		result = service.findAll();
		return result;
	}

	@RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
	public Customer findById(@PathVariable("id") long id) {
		Customer result=null;
		if(id!=0) {
			result = service.findById(id);
		}
		return result;
	}


	@RequestMapping(value = "/customer", method = RequestMethod.POST)
	public Customer saveData(@RequestBody Customer customer) {
		Customer c=null;
		if(customer!=null&&customer.getFirstName()!=null&&customer.getLastName()!=null&&customer.getFirstName()!=""&&customer.getLastName()!="") {
			c=service.saveData(customer);
		}
		
		return c;
	}

	@RequestMapping(value = "/customer/{id}", method = RequestMethod.PUT)
	public Customer updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer) {
		Customer result=null;
		if(id!=0&&customer!=null&&customer.getFirstName()!=null&&customer.getLastName()!=null&&customer.getFirstName()!=""&&customer.getLastName()!="") {
			result = service.updateCustomer(id,customer);
		}
		return result;
	}

	@RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") long id) {
		String out="Not done";
		if(id!=0) {
			out=service.delete(id);
			return out;
		}
		
		return out;
		
		
	}

}