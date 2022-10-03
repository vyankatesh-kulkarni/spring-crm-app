package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject sessionfactory dependancy
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		//create query
		Query<Customer> query = session.createQuery("from Customer order by lastName", Customer.class);
	
		//execute quert and get result
		List<Customer> customers = query.getResultList();
		
		// return result
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		 
		Session session  = sessionFactory.getCurrentSession();
		session.saveOrUpdate(theCustomer);
		
		
	}

	@Override
	public Customer getCustomer(int theId) {
		Session session  = sessionFactory.getCurrentSession();
		Customer theCustomer = session.get(Customer.class, theId);
		return theCustomer;
	}

	@Override
	public void delete(int theId) {
		Session session  = sessionFactory.getCurrentSession();	
		
		Query theQuery = session.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId",theId);
		theQuery.executeUpdate();
		
	}

}
