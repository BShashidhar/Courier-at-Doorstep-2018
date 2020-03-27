package com.vov.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vov.dao.ServiceProviderDaoIF;
import com.vov.pojos.ServiceProvider;

@Service
@Transactional
public class ServiceProviderService implements ServiceProviderServiceIF{

	@Autowired
	private ServiceProviderDaoIF sdao;
	
	@Override
	public ServiceProvider saveServiceProvider(ServiceProvider sp) {
		if (sdao.saveServiceProvider(sp) != null) {
			return sp;
		}
		return null;
	}

	@Override
	public ServiceProvider getServiceProviderById(int id) {
		ServiceProvider sp = null;
		sp = sdao.getServiceProviderById(id);
		if (sp != null) {
			return sp;
		}
		return null;
	}
	@Override
	public ServiceProvider updateServiceProvider(int id, String name, String phoneNo) {
		ServiceProvider sp=null;
		sp=sdao.updateServiceProvider(id, name, phoneNo);
		if(sp!=null){
		return sp;
		}
		return null;
	}

	@Override
	public String deleteServiceProvider(int id) {
		ServiceProvider sp=null;
		sp=sdao.deleteServiceProvider(id);
		return "Deleted Service provider with details:"+sp;
		
	}
	
	@Override
	public ServiceProvider validateServiceProvider(ServiceProvider sp) {		
		return sdao.validateServiceProvider(sp);
	}
	
	@Override
	public List<ServiceProvider> getProviders() {
		return sdao.getProviders();
	}
}
