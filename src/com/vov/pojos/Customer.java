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
@Table(name="customer")
public class Customer 
{
	private Integer custid;
	private String name,email,passwrod;
	private String phoneno;
	public Customer() 
	{
	}
	
	public Customer(Integer custid, String name, String email, String passwrod, String phoneno) 
	{
		super();
		this.custid = custid;
		this.name = name;
		this.email = email;
		this.passwrod = passwrod;
		this.phoneno = phoneno;
	}
	public Customer( String name, String email, String passwrod, String phoneno) 
	{
		super();
		this.name = name;
		this.email = email;
		this.passwrod = passwrod;
		this.phoneno = phoneno;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getCustid() 
	{
		return custid;
	}
	public void setCustid(Integer custid) 
	{
		this.custid = custid;
	}
	
	@NotBlank(message="Name is required")
	@Length(min=2,max=50,message="Length(2-50)")
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	
	@NotBlank(message="Name is required")
	@Length(min=6,max=50,message="Length(2-50)")
	@Email(message="Invalid Email")
	public String getEmail() 
	{
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}
	
	@NotBlank(message="Password is required")
	@Length(min=6,max=20,message="Length(6-50)")
	public String getPasswrod() 
	{
		return passwrod;
	}
	public void setPasswrod(String passwrod) 
	{
		this.passwrod = passwrod;
	}
	
	@Pattern(regexp="(^$|[0-9]{10})")
	public String getPhoneno() 
	{
		return phoneno;
	}
	public void setPhoneno(String phoneno) 
	{
		this.phoneno = phoneno;
	}
}
