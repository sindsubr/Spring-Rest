package org.sindu.restapi.service;

import java.util.List;

import org.sindu.restapi.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers(); // GET Request
	public Customer getCustomer(int customerId); // GET Request
	public void saveCustomer(Customer customer); //POST Request
	public void deleteCustomer(int customerId); //Delete Request
	public void updateCustomer(Customer customer);

}
