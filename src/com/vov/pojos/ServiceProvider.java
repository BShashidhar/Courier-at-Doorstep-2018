package com.vov.pojos;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="provider")
public class ServiceProvider {
	private Integer pid;
	private String name,email,password;
	private String phoneno;
	private String status;
	
	public ServiceProvider() {
		super();
	}

	public ServiceProvider(Integer pid, String name, String email, String password, String phoneno, String status) {
		super();
		this.pid = pid;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phoneno = phoneno;
		this.status = status;
	}

	public ServiceProvider(String name, String email, String password, String phoneno, String status) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.phoneno = phoneno;
		this.status = status;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	
	@NotBlank(message="Service name is mandatory")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@NotBlank(message="Email is mandatory")
	@Email(message="Enter valid email id")
	@Length(min=6,max=50,message="Invalid email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@NotBlank(message="Password is mandatory")
	@Length(min=6,max=20,message="Length must be in between 6-20")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Pattern(regexp="(^$|[0-9]{10})")
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	@Length(min=4,max=5,message="Status of Service Provider")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

	/*@OneToMany(targetEntity=ServiceRegistration.class,cascade=CascadeType.ALL,
			mappedBy="sprovider")
	public ArrayList<ServiceRegistration> getServices() {
		return services;
	}

	public void setServices(ArrayList<ServiceRegistration> services) {
		this.services = services;
	}
	//Convenience method to persist services
	public void addServices(ServiceRegistration service) {
		services.add(service);
		service.setSprovider(this);
	}*/
}
