package io.javabrains.moviecatalogservice.model;

public class Rating {

	private String movieIdl;
	private int rating;
	
	public Rating(String movieIdl, int rating) {
		super();
		this.movieIdl = movieIdl;
		this.rating = rating;
	}
	public String getMovieIdl() {
		return movieIdl;
	}
	public void setMovieIdl(String movieIdl) {
		this.movieIdl = movieIdl;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
}
