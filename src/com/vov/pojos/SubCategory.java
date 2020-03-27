package com.vov.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="subcategory")
public class SubCategory {
	private Integer scid;
	private String name,image,description;
	private Category category;
	

	
	public SubCategory() {
	}
	
	public SubCategory(String name, String image, String desc, Category category) {
		super();
		this.name = name;
		this.image = image;
		this.description = desc;
		this.category = category;
	}

	public SubCategory(Integer scid, String name, String image, String desc, Category category) {
		super();
		this.scid = scid;
		this.name = name;
		this.image = image;
		this.description = desc;
		this.category = category;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getScid() {
		return scid;
	}

	public void setScid(Integer scid) {
		this.scid = scid;
	}
	
	@NotBlank(message="Name is REQUIRED")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotBlank(message="Please select an image")
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@NotBlank(message="Desc is REQUIRED")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	//This is the OWNING SIDE because it is having foreign key.....
	@OneToOne(cascade=CascadeType.ALL,targetEntity=Category.class,fetch=FetchType.EAGER)
	@JoinColumn(name="cat_id")
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "SubCategory [scid=" + scid + ", name=" + name + ", image=" + image + ", description=" + description
				+ ", category=" + category + "]";
	}
	
}
