package com.mymovies.dto;

import java.util.ArrayList;

public class ReviewsDTO {
	
	// Attributs

	private long id;

	private int page;
	
	private ArrayList<ReviewDTO> results;
		
	private int total_pages;

	private int total_results;

	public ReviewsDTO() {
		super();
	}

	public ReviewsDTO(long id, int page, ArrayList<ReviewDTO> results, int total_pages, int total_results) {
		super();
		this.id = id;
		this.page = page;
		this.results = results;
		this.total_pages = total_pages;
		this.total_results = total_results;
	}

	@Override
	public String toString() {
		return "ReviewsDTO [id=" + id + ", page=" + page + ", results=" + results + ", total_pages=" + total_pages
				+ ", total_results=" + total_results + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public ArrayList<ReviewDTO> getResults() {
		return results;
	}

	public void setResults(ArrayList<ReviewDTO> results) {
		this.results = results;
	}

	public int getTotal_pages() {
		return total_pages;
	}

	public void setTotal_pages(int total_pages) {
		this.total_pages = total_pages;
	}

	public int getTotal_results() {
		return total_results;
	}

	public void setTotal_results(int total_results) {
		this.total_results = total_results;
	}
	
}