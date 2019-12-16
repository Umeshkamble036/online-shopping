package com.uk.shoppingbackend.dto;

public class CategeoryDTOBean {
	
//	private variables/fields
	private int id;
	private String name;
	private String imageURL;
	private String description;
	private boolean active=true;
	
	public CategeoryDTOBean() {
		System.out.println("CategeoryDTOBean.CategeoryDTOBean()");
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "CategeoryDTOBean [id=" + id + ", name=" + name + ", imageURL=" + imageURL + ", description="
				+ description + ", active=" + active + "]";
	}
}
