package com.mymovies.dto;

import java.util.ArrayList;
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class MovieDTO {

	// Attributs
	
	private boolean adult;
	
	private String backdrop_path;
	
	private Object belongs_to_collection;
	
	private int budget;
	
	private ArrayList<GenreDTO> genres;
	
	private String homepage;
	
	private int id;
	
	@Min(value = 9)
	@Max(value = 9)
	private String imdb_id; // minLength: 9 maxLength: 9
	
	private String original_language;
	
	private String original_title;
	
	private String overview;

	private Double popularity;
	
	private String poster_path;
	
	private ArrayList<Production_CompaniesDTO> production_companies;
	
	private ArrayList<Production_CountriesDTO> production_countries;

	private Date release_date;
	
	private int revenue;
	
	private int runtime;
	
	private ArrayList<Spoken_LanguagesDTO> spoken_languages;

	private String status;
	
	private String tagline;
	
	private String title;
	
	private boolean video;
	
	private Number vote_average;
	
	private int vote_count;

	// Override toString
	
	@Override
	public String toString() {
		return "MovieDTO [adult=" + adult + ", backdrop_path=" + backdrop_path + ", belongs_to_collection="
				+ belongs_to_collection + ", budget=" + budget + ", genres=" + genres + ", homepage=" + homepage
				+ ", id=" + id + ", imdb_id=" + imdb_id + ", original_language=" + original_language
				+ ", original_title=" + original_title + ", overview=" + overview + ", popularity=" + popularity +
				", poster_path=" + poster_path + ", production_companies=" + production_companies
				+ ", production_countries=" + production_countries + ", release_date=" + release_date +
				", revenue=" + revenue + ", runtime=" + runtime + ", spoken_languages=" + spoken_languages
				+ ", status=" + status + ", tagline=" + tagline + ", title=" + title + ", video=" + video
				+ ", vote_average=" + vote_average + ", vote_count=" + vote_count + "]";
	}

	// Constructor from SuperClass
	
	public MovieDTO() {
		super();
	}
	
	// Constructor Using Fields

	public MovieDTO(boolean adult, String backdrop_path, Object belongs_to_collection, int budget,
			ArrayList<GenreDTO> genres, String homepage, int id, @Min(9) @Max(9) String imdb_id,
			String original_language, String original_title, String overview, Double popularity, String poster_path,
			ArrayList<Production_CompaniesDTO> production_companies,
			ArrayList<Production_CountriesDTO> production_countries, Date release_date, int revenue, int runtime,
			ArrayList<Spoken_LanguagesDTO> spoken_languages, String status, String tagline, String title, boolean video,
			Number vote_average, int vote_count) {
		super();
		this.adult = adult;
		this.backdrop_path = backdrop_path;
		this.belongs_to_collection = belongs_to_collection;
		this.budget = budget;
		this.genres = genres;
		this.homepage = homepage;
		this.id = id;
		this.imdb_id = imdb_id;
		this.original_language = original_language;
		this.original_title = original_title;
		this.overview = overview;
		this.popularity = popularity;
		this.poster_path = poster_path;
		this.production_companies = production_companies;
		this.production_countries = production_countries;
		this.release_date = release_date;
		this.revenue = revenue;
		this.runtime = runtime;
		this.spoken_languages = spoken_languages;
		this.status = status;
		this.tagline = tagline;
		this.title = title;
		this.video = video;
		this.vote_average = vote_average;
		this.vote_count = vote_count;
	}

	// Getters and Setters
	
	public boolean isAdult() {
		return adult;
	}

	public void setAdult(boolean adult) {
		this.adult = adult;
	}

	public String getBackdrop_path() {
		return backdrop_path;
	}

	public void setBackdrop_path(String backdrop_path) {
		this.backdrop_path = backdrop_path;
	}

	public Object getBelongs_to_collection() {
		return belongs_to_collection;
	}

	public void setBelongs_to_collection(Object belongs_to_collection) {
		this.belongs_to_collection = belongs_to_collection;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public ArrayList<GenreDTO> getGenres() {
		return genres;
	}

	public void setGenres(ArrayList<GenreDTO> genres) {
		this.genres = genres;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImdb_id() {
		return imdb_id;
	}

	public void setImdb_id(String imdb_id) {
		this.imdb_id = imdb_id;
	}

	public String getOriginal_language() {
		return original_language;
	}

	public void setOriginal_language(String original_language) {
		this.original_language = original_language;
	}

	public String getOriginal_title() {
		return original_title;
	}

	public void setOriginal_title(String original_title) {
		this.original_title = original_title;
	}

	public Double getPopularity() {
		return popularity;
	}

	public void setPopularity(Double popularity) {
		this.popularity = popularity;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getPoster_path() {
		return poster_path;
	}

	public void setPoster_path(String poster_path) {
		this.poster_path = poster_path;
	}

	public ArrayList<Production_CompaniesDTO> getProduction_companies() {
		return production_companies;
	}

	public void setProduction_companies(ArrayList<Production_CompaniesDTO> production_companies) {
		this.production_companies = production_companies;
	}

	public ArrayList<Production_CountriesDTO> getProduction_countries() {
		return production_countries;
	}

	public void setProduction_countries(ArrayList<Production_CountriesDTO> production_countries) {
		this.production_countries = production_countries;
	}

	public Date getRelease_date() {
		return release_date;
	}

	public void setRelease_date(Date release_date) {
		this.release_date = release_date;
	}

	public int getRevenue() {
		return revenue;
	}

	public void setRevenue(int revenue) {
		this.revenue = revenue;
	}

	public int getRuntime() {
		return runtime;
	}

	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}

	public ArrayList<Spoken_LanguagesDTO> getSpoken_languages() {
		return spoken_languages;
	}

	public void setSpoken_languages(ArrayList<Spoken_LanguagesDTO> spoken_languages) {
		this.spoken_languages = spoken_languages;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTagline() {
		return tagline;
	}

	public void setTagline(String tagline) {
		this.tagline = tagline;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isVideo() {
		return video;
	}

	public void setVideo(boolean video) {
		this.video = video;
	}

	public Number getVote_average() {
		return vote_average;
	}

	public void setVote_average(Number vote_average) {
		this.vote_average = vote_average;
	}

	public int getVote_count() {
		return vote_count;
	}

	public void setVote_count(int vote_count) {
		this.vote_count = vote_count;
	}

}
