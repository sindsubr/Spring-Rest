package org.sindu.restapi.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.sindu.restapi.entity.Customer;
import org.sindu.restapi.restexceptionhandler.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		Session session = sessionFactory.openSession();
		Query<Customer> query = session.createQuery("from Customer", Customer.class);
		List<Customer> customers = query.getResultList();
		return customers;
	}

	@Override
	public Customer getCustomer(int customerId) {
		Session session = sessionFactory.openSession();
		Customer customer = null;
		customer = session.get(Customer.class, customerId);
		if (customer == null)
			throw new CustomerNotFoundException("Customer Id not found..!! " + customerId);
		return customer;
	}

	@Override
	public Customer addCustomer(Customer customer) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.persist(customer);
		session.getTransaction().commit();
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer, int customerId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Customer customerToUpdate = session.get(Customer.class, customerId);
		if (customerToUpdate == null)
			throw new CustomerNotFoundException("Customer Id not found..!! " + customerId);
		customerToUpdate.setFirstName(customer.getFirstName());
		customerToUpdate.setLastName(customer.getLastName());
		customerToUpdate.setEmail(customer.getEmail());
		session.merge(customerToUpdate);
		session.getTransaction().commit();
		return customer;
	}

	@Override
	public void deleteCustomer(int customerId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Customer customer = session.get(Customer.class, customerId);
		if (customer == null)
			throw new CustomerNotFoundException("Customer Id not found..!! " + customerId);
		session.remove(customer);
		session.getTransaction().commit();
	}

}
