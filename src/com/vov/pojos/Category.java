package com.vov.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

//Category class will have all master categories like Adventurous, tourist destinations etc.
@Entity
@Table(name="category")
public class Category {
	private Integer cid;
	private String name,image,description;
	
	
	public Category(Integer cid, String name, String image, String description) {
		super();
		this.cid = cid;
		this.name = name;
		this.image = image;
		this.description = description;
	}

	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Category(String name, String image, String description) {
		super();
		this.name = name;
		this.image = image;
		this.description = description;
	}


	/*private Integer cid;
	private String name,image,description;
	private List<SubCategory> subcategories = new ArrayList<>();
	
	public Category() {
		
	}
	
	public Category(String name, String image, String desc, List<SubCategory> subcategories) {
		super();
		this.name = name;
		this.image = image;
		this.description = desc;
		this.subcategories = subcategories;
	}

	public Category(Integer cid, String name, String image, String desc, List<SubCategory> subcategories) {
		super();
		this.cid = cid;
		this.name = name;
		this.image = image;
		this.description = desc;
		this.subcategories = subcategories;
	}

*/	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	//This is category name
	@NotBlank(message="Name is REQUIRED....")
	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}
	
	//This is category image to be displayed
	@NotBlank(message="Please select an image....")
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
	@NotBlank(message="description is REQUIRED....")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	//This is an INVERSE SIDE because it is not having foreign key......
	/*@OneToMany(targetEntity=SubCategory.class,mappedBy="category",
			cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	public List<SubCategory> getSubcategories() {
		return subcategories;
	}


	public void setSubcategories(List<SubCategory> subcategories) {
		this.subcategories = subcategories;
	}*/
	
	//Convenience method sub-category into  category
	/*public void addSubCategory(SubCategory sub) {
		subcategories.add(sub);
		sub.setCategory(this);
	}*/
}