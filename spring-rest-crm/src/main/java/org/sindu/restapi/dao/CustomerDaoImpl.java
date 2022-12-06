package org.sindu.restapi.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.sindu.restapi.entity.Customer;
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
		Customer customer = session.get(Customer.class, customerId);
		return customer;
	}

	@Override
	public Customer addCustomer(Customer customer) {
		Session session = sessionFactory.openSession();
//		customer.setId(0); //For adding new customer entity
		session.beginTransaction();
		session.persist(customer);
		session.getTransaction().commit();
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.merge(customer);
		session.getTransaction().commit();
		return customer;
	}

	@Override
	public void deleteCustomer(int customerId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.remove(session.get(Customer.class, customerId));
		session.getTransaction().commit();
	}

}
