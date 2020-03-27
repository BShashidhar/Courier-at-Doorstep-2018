package com.vov.service;

import java.util.List;

import com.vov.pojos.ServiceProvider;

public interface ServiceProviderServiceIF {
	public ServiceProvider saveServiceProvider(ServiceProvider sp);
	public ServiceProvider getServiceProviderById(int id);
	public String deleteServiceProvider(int id);
	public ServiceProvider updateServiceProvider(int id, String name, String phoneNo);
	public ServiceProvider validateServiceProvider(ServiceProvider sp);
	public List<ServiceProvider> getProviders();
}
