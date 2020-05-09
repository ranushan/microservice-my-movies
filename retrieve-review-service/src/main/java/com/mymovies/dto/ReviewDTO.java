package com.mymovies.dto;

public class ReviewDTO {
	
	// Attributs

	private String id;
	
	private String author;
	
	private String content;
	
	private String url;

	// Constructor From SuperClass
	
	public ReviewDTO() {
		super();
	}
	
	// Constructor Using Fields
	
	public ReviewDTO(String id, String author, String content, String url) {
		super();
		this.id = id;
		this.author = author;
		this.content = content;
		this.url = url;
	}
	
	// Override toString
	
	@Override
	public String toString() {
		return "ReviewDTO [id=" + id + ", author=" + author + ", content=" + content + ", url=" + url + "]";
	}

	// Getters and Setters
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}