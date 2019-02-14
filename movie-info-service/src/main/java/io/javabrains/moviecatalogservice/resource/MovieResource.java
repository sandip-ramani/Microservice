package io.javabrains.moviecatalogservice.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.moviecatalogservice.model.Movie;

@RestController
@RequestMapping("/movie")
public class MovieResource {

	@GetMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable("movieId") String movieId){
		return new Movie(movieId,"hawk");
	} 
}
