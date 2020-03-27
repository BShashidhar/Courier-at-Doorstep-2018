package com.vov.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="admin")
public class Admin {
	private Integer adminid;
	private String password;
	
	public Admin() {
		super();
	}
	
	public Admin(Integer adminid, String password) {
		super();
		this.adminid = adminid;
		this.password = password;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getAdminid() {
		return adminid;
	}

	public void setAdminid(Integer adminid) {
		this.adminid = adminid;
	}

	@NotBlank(message="Password is mandatory")
	@Length(min=6,max=20,message="Range (6-20) characters")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
