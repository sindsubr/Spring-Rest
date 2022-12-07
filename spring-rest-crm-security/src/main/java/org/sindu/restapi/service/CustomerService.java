package org.sindu.restapi.service;

import java.util.List;

import org.sindu.restapi.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers(); // GET Request
	public Customer getCustomer(int customerId); // GET Request
	public Customer addCustomer(Customer customer); //POST Request
	public Customer updateCustomer(Customer customer,int customerId); //PUT Request
	public void deleteCustomer(int customerId); //Delete Request

}
