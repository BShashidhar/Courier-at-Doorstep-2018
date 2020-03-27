package com.vov.pojos;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
@Entity
@Table(name="servicesenrolled")
public class ServiceRegistration 
{
	private Integer id;
	private String name,city,address,image1,image2,image3,status,rating,description,timing,peaktime;
	private double priceA,priceC;
	private ServiceProvider sprovider;
	//private Category category;
	private SubCategory subcategory;	
	public ServiceRegistration() 
	{
		super();
	}

	public ServiceRegistration(Integer id, String name, String city, String address, String image1, String image2,
			String image3, String status, String rate, String description, String timing, String peaktime,
			    double priceA, double priceC, ServiceProvider sprovider, SubCategory subcategory) 
	{
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.address = address;
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
		this.status = status;
		this.rating = rate;
		this.description = description;
		this.timing = timing;
		this.peaktime = peaktime;
		this.priceA = priceA;
		this.priceC = priceC;
		this.sprovider = sprovider;
		//this.category = category;
		this.subcategory = subcategory;
	}
	public ServiceRegistration(String name, String city, String address, String image1, String image2, String image3,
			String status, String rate, String description, String timing, String peaktime, double priceA,
			double priceC, ServiceProvider sprovider, SubCategory subcategory) 
	{
		super();
		this.name = name;
		this.city = city;
		this.address = address;
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
		this.status = status;
		this.rating = rate;
		this.description = description;
		this.timing = timing;
		this.peaktime = peaktime;
		this.priceA = priceA;
		this.priceC = priceC;
		this.sprovider = sprovider;
		//this.category = category;
		this.subcategory = subcategory;
	}	

	public ServiceRegistration(String name, String city, String address, String image1, String status, String rating,
			String description, String timing, String peaktime, double priceA, double priceC, ServiceProvider sprovider, SubCategory subcategory) 
	{
		super();
		this.name = name;
		this.city = city;
		this.address = address;
		this.image1 = image1;
		this.status = status;
		this.rating = rating;
		this.description = description;
		this.timing = timing;
		this.peaktime = peaktime;
		this.priceA = priceA;
		this.priceC = priceC;
		this.sprovider = sprovider;
		//this.category = category;
		this.subcategory = subcategory;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() 
	{
		return id;
	}
	public void setId(Integer id) 
	{
		this.id = id;
	}

	@NotBlank(message="Name is REQUIRED")
	@Length(min=2,max=50,message="Range(3-50) characters")
	public String getName() 
	{
		return name;
	}


	public void setName(String name) 
	{
		this.name = name;
	}

	@NotBlank(message="City is REQUIRED")
	@Length(min=3,max=50,message="Range(3-50) characters")
	public String getCity() 
	{
		return city;
	}
	public void setCity(String city) 
	{
		this.city = city;
	}

	
	@NotNull(message="Address is REQUIRED")
	@Length(min=10,max=150,message="Range(20-150) characters")
	public String getAddress() 
	{
		return address;
	}
	public void setAddress(String address) 
	{
		this.address = address;
	}
	

	//@NotBlank(message="Image is REQUIRED")
	@Length(min=2,max=100,message="Range(3-100) characters")
	public String getImage1() 
	{
		return image1;
	}
	public void setImage1(String image1) 
	{
		this.image1 = image1;
	}

	@Basic(optional=true)
	public String getImage2() 
	{
		return image2;
	}
	public void setImage2(String image2) 
	{
		this.image2 = image2;
	}

	
	@Basic(optional=true)
	public String getImage3() 
	{
		return image3;
	}
	public void setImage3(String image3) 
	{
		this.image3 = image3;
	}

	
	@NotBlank(message="Status is required")
	public String getStatus() 
	{
		return status;
	}
	public void setStatus(String status) 
	{
		this.status = status;
	}

	
	public String getRating() 
	{
		return rating;
	}
	public void setRating(String rating) 
	{
		this.rating = rating;
	}

	
	@NotBlank(message="Description is REQUIRED")
	@Length(min=20,max=150,message="Range(20-150) characters")
	public String getDescription() 
	{
		return description;
	}


	public void setDescription(String description) 
	{
		this.description = description;
	}

	@NotBlank(message="Timing is REQUIRED")
	public String getTiming() 
	{
		return timing;
	}
	public void setTiming(String timing) 
	{
		this.timing = timing;
	}

	
	//@NotBlank(message="Peaktime is REQUIRED")
	public String getPeaktime() 
	{
		return peaktime;
	}
	public void setPeaktime(String peaktime) 
	{
		this.peaktime = peaktime;
	}
	

	@Column(precision=10,scale=5)
	public double getPriceA() 
	{
		return priceA;
	}
	public void setPriceA(double priceA) 
	{
		this.priceA = priceA;
	}

	
	@Basic(optional=false)
	public double getPriceC() 
	{
		return priceC;
	}
	public void setPriceC(double priceC) 
	{
		this.priceC = priceC;
	}

	@OneToOne(cascade=CascadeType.ALL,targetEntity=ServiceProvider.class,fetch=FetchType.EAGER)
	@JoinColumn(name="p_id")
	public ServiceProvider getSprovider() 
	{
		return sprovider;
	}
	public void setSprovider(ServiceProvider sprovider) 
	{
		this.sprovider = sprovider;
	}
	
	/*@OneToOne(cascade=CascadeType.ALL,targetEntity=Category.class,fetch=FetchType.EAGER)
	@JoinColumn(name="cat_id")
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}*/
	
	@OneToOne(cascade=CascadeType.ALL,targetEntity=SubCategory.class,fetch=FetchType.EAGER)
	@JoinColumn(name="subcat_id")
	
	public SubCategory getSubcategory() 
	{
		return subcategory;
	}
	public void setSubcategory(SubCategory subcategory) 
	{
		this.subcategory = subcategory;
	}
}
