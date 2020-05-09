package com.mymovies.dto;

public class Production_CompaniesDTO {
	
	// Attributs
	
	private String name;
	
	private long id;
	
	private String logo_path;

	private String origin_country;
	
	// Override toString 
	
	@Override
	public String toString() {
		return "Production_CompaniesDTO [name=" + name + ", id=" + id + ", logo_path=" + logo_path + ", origin_country="
				+ origin_country + "]";
	}

	// Constructor From SuperClass

	public Production_CompaniesDTO() {
		super();
	}
	
	// Constructor Using Fields

	public Production_CompaniesDTO(String name, long id, String logo_path, String origin_country) {
		super();
		this.name = name;
		this.id = id;
		this.logo_path = logo_path;
		this.origin_country = origin_country;
	}

	// Getters and Setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogo_path() {
		return logo_path;
	}

	public void setLogo_path(String logo_path) {
		this.logo_path = logo_path;
	}

	public String getOrigin_country() {
		return origin_country;
	}

	public void setOrigin_country(String origin_country) {
		this.origin_country = origin_country;
	}
	
}

