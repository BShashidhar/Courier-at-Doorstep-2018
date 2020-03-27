package com.vov.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vov.pojos.ServiceProvider;

@Repository
public class ServiceProviderDao implements ServiceProviderDaoIF{

	@Autowired
	private SessionFactory sf;
	
	@Override
	public ServiceProvider saveServiceProvider(ServiceProvider sp) 
	{
		if ((Integer)sf.getCurrentSession().save(sp) != null) 
		{
			return sp;
		}
		return null;
	}
	
	@Override
	public ServiceProvider getServiceProviderById(int id) 
	{
		return (ServiceProvider)sf.getCurrentSession().get(ServiceProvider.class,id);
	}
	@Override
	public ServiceProvider updateServiceProvider(int id, String name, String phoneNo) 
	{
		ServiceProvider sp=getServiceProviderById(id);
		sp.setName(name);
		sp.setPhoneno(phoneNo);
		return sp;
	}

	@Override
	public ServiceProvider deleteServiceProvider(int id) 
	{
		ServiceProvider sp=getServiceProviderById(id);
		sf.getCurrentSession().delete(sp);
		return sp;
		
	}
	@Override
	public ServiceProvider validateServiceProvider(ServiceProvider sp) 
	{		
		return (ServiceProvider) sf.getCurrentSession()
			.createQuery("Select sp from ServiceProvider sp where sp.email=:email and sp.password=:pass")
			.setParameter("email", sp.getEmail())
			.setParameter("pass", sp.getPassword())
			.getSingleResult();
		
	}
	
	@Override
	public List<ServiceProvider> getProviders() 
	{
		return sf.getCurrentSession().createQuery("Select sps from ServiceProvider sps",
				ServiceProvider.class)
				.getResultList();
	}
}
