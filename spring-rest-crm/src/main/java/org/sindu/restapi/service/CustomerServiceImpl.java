package org.sindu.restapi.service;

import java.util.List;

import javax.transaction.Transactional;

import org.sindu.restapi.dao.CustomerDao;
import org.sindu.restapi.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerDao;
	
	@Transactional
	@Override
	public List<Customer> getCustomers() {
		return customerDao.getCustomers();
	}

	@Transactional
	@Override
	public Customer getCustomer(int customerId) {
		return customerDao.getCustomer(customerId);
	}

	@Transactional
	@Override
	public Customer addCustomer(Customer customer) {
		return customerDao.addCustomer(customer);
	}

	@Transactional
	@Override
	public Customer updateCustomer(Customer customer) {
		return customerDao.updateCustomer(customer);

	}

	@Transactional
	@Override
	public void deleteCustomer(int customerId) {
		customerDao.deleteCustomer(customerId);
	}

}
