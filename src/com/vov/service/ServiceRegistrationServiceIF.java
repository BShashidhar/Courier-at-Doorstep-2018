package com.vov.service;

import java.util.List;

import com.vov.pojos.ServiceRegistration;

public interface ServiceRegistrationServiceIF {
	public ServiceRegistration saveService(ServiceRegistration sr);
	public ServiceRegistration getService(int id);
	public ServiceRegistration deleteService(int id);
	public ServiceRegistration updateService(ServiceRegistration sr);
	public List<ServiceRegistration> searchService(String st);
	public List<ServiceRegistration> getServiceByProviderID(int id);
	public List<ServiceRegistration> getServiceBySubCategoryId(int id);
}
