package com.vov.dao;

import java.util.List;

import com.vov.pojos.ServiceProvider;

public interface ServiceProviderDaoIF {
	public ServiceProvider saveServiceProvider(ServiceProvider sp);
	public ServiceProvider getServiceProviderById(int id);
	public ServiceProvider updateServiceProvider(int id, String name, String phoneNo);
	public ServiceProvider deleteServiceProvider(int id);
	public ServiceProvider validateServiceProvider(ServiceProvider sp);
	public List<ServiceProvider> getProviders();
}
