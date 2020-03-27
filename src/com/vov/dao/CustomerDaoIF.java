package com.vov.dao;

import com.vov.pojos.Customer;

public interface CustomerDaoIF 
{
	public Customer saveCustomer(Customer c);

	public Customer getCustomer(int id);

	public Customer updateCustomer(Customer c);

	public Customer deleteCustomer(int id);
}
