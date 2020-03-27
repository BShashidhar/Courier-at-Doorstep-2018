package com.vov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vov.dao.CustomerDaoIF;
import com.vov.pojos.Customer;

@Service
@Transactional
public class CustomerService implements CustomerServiceIF{

	@Autowired
	private CustomerDaoIF custdao;
	
	public CustomerService() {
	}
	
	@Override
	public Customer saveCustomer(Customer c) {
		if (custdao.saveCustomer(c) != null) {
			return c;
		}
		return null;
	}

	
	@Override
	public Customer getCustomer(int id) {
		return custdao.getCustomer(id);
	}

	@Override
	public Customer updateCustomer(Customer c) {
		return custdao.updateCustomer(c);
	}
	
	@Override
	public Customer deleteCustomer(int id) {
		return custdao.deleteCustomer(id);
	}

}
