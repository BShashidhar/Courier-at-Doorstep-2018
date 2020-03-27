package com.vov.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vov.dao.ServiceRegistrationDaoIF;
import com.vov.pojos.ServiceRegistration;

@Service
@Transactional
public class ServiceRegistrationService implements ServiceRegistrationServiceIF {

	@Autowired
	private ServiceRegistrationDaoIF srdao;
	
	@Override
	public ServiceRegistration saveService(ServiceRegistration sr) {
		if (srdao.saveService(sr)!= null) {
			return sr;
		}
		return null;
	}

	@Override
	@Transactional(readOnly=true)
	public ServiceRegistration getService(int id) {
		return srdao.getService(id);
	}

	@Override
	public ServiceRegistration deleteService(int id) {
		return srdao.deleteService(id);
	}
	
	@Override
	public ServiceRegistration updateService(ServiceRegistration sr) {
		return srdao.updateService(sr);
	}
	
	@Transactional(readOnly=true)
	@Override
	public List<ServiceRegistration> searchService(String st) {
		
		return srdao.searchService(st);
	}
	
	@Transactional(readOnly=true)
	@Override
	public List<ServiceRegistration> getServiceByProviderID(int id) {
		return srdao.getServiceByProviderID(id);
	}
	
	@Transactional(readOnly=true)
	@Override
	public List<ServiceRegistration> getServiceBySubCategoryId(int id) {
		return srdao.getServiceBySubCategoryId(id);
	}
}
