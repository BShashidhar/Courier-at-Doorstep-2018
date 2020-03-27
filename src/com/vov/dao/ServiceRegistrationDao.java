package com.vov.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vov.pojos.ServiceRegistration;

@Repository
public class ServiceRegistrationDao implements ServiceRegistrationDaoIF{
	
	@Autowired
	private SessionFactory sf;
	
	@Override
	public ServiceRegistration saveService(ServiceRegistration sr) {
		if((Integer)sf.getCurrentSession().save(sr) != null) {
			return sr;
		}
		return null;
	}

	@Override
	public ServiceRegistration getService(int id) {
		return sf.getCurrentSession().get(ServiceRegistration.class,id);
	}
	
	@Override
	public ServiceRegistration deleteService(int id) {
		ServiceRegistration sr = getService(id);
		sr.setSprovider(null);
		sr.setSubcategory(null);
		sf.getCurrentSession().delete(sr);
		return sr;
	}
	
	@Override
	public ServiceRegistration updateService(ServiceRegistration sr) 
	{
		ServiceRegistration sr2 = getService(sr.getId());
		sr2.setName(sr.getName());
		sr2.setCity(sr.getCity());
		sr2.setAddress(sr.getAddress());
		sr2.setDescription(sr.getDescription());
		sr2.setImage1(sr.getImage1());
		sr2.setImage2(sr.getImage2());
		sr2.setImage3(sr.getImage3());
		sr2.setPriceA(sr.getPriceA());
		sr2.setPriceC(sr.getPriceC());
		sr2.setPeaktime(sr.getPeaktime());
		sr2.setRating(sr.getRating());
		sr2.setStatus(sr.getStatus());
		sr2.setTiming(sr.getTiming());
		return sr;
	}
	@Override
	public List<ServiceRegistration> searchService(String st) 
	{
		return sf.getCurrentSession()
				.createQuery("select sr from ServiceRegistration sr where sr.city like concat('%',:serchString,'%' )"
						,ServiceRegistration.class).setParameter("serchString", st)
				.getResultList();
		
	}
	@Override
	public List<ServiceRegistration> getServiceByProviderID(int id) {
		return sf.getCurrentSession()
				.createQuery("select sr from ServiceRegistration sr where sr.sprovider.pid =:pid"
						,ServiceRegistration.class)
				.setParameter("pid", id).getResultList();
	}
	
	@Override
	public List<ServiceRegistration> getServiceBySubCategoryId(int id) {
		return sf.getCurrentSession()
				.createQuery("select sr from ServiceRegistration sr where sr.subcategory.scid =:scid"
						,ServiceRegistration.class)
				.setParameter("scid", id).getResultList();
	}
}