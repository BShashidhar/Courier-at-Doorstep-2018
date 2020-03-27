package com.vov.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vov.pojos.Customer;

@Repository
public class CustomerDao implements CustomerDaoIF{

	@Autowired
	private SessionFactory sf;
	
	public CustomerDao() {
	}
	
	@Override
	public Customer saveCustomer(Customer c) 
	{
		if ((Integer)sf.getCurrentSession().save(c) != null) 
		{
			return c;
		}
		return null;
	}
	
	@Override
	public Customer getCustomer(int id) 
	{
		return sf.getCurrentSession().get(Customer.class, id);
	}
	
	@Override
	public Customer updateCustomer(Customer c) 
	{
		Customer c2 = getCustomer(c.getCustid());
		c2.setName(c.getName());
		c2.setPasswrod(c.getPasswrod());
		c2.setPhoneno(c.getPhoneno());
		return c2;
	}
	
	@Override
	public Customer deleteCustomer(int id) 
	{
		Customer c = getCustomer(id);
		sf.getCurrentSession().delete(c);
		return c;
	}
}
