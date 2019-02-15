package io.javabrains.moviecatalogservice.resource;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import io.javabrains.moviecatalogservice.model.CatalogItem;
import io.javabrains.moviecatalogservice.model.Movie;
import io.javabrains.moviecatalogservice.model.Rating;
import io.javabrains.moviecatalogservice.model.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	@Autowired
	RestTemplate rest;
	
	@Autowired
	WebClient.Builder builder;
	
	@GetMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
	//	RestTemplate rest = new RestTemplate();
	//	Movie movie  = rest.getForObject("http://localhost:8081/movie/sandip", Movie.class);
		//get all rated movie IDs
		
		
		UserRating ratings = (UserRating) rest.getForObject("http://localhost:8083/ratingsdata/user/"+userId, UserRating.class);
				

	    List<CatalogItem> rating = ratings.getUserRating().stream()
	                                .map(s -> {
	                                	final Movie	 movie  = rest.getForObject("http://localhost:8082/movie/"+s.getMovieIdl(), Movie.class);
	                                	/* Asynchronous call using web client
	                                	final Movie	 movie = 	builder.build().get()
	                                	.uri("http://localhost:8082/movie/"+s.getMovieIdl())
	                                	.retrieve().bodyToMono(Movie.class).block();*/
	                                	return new CatalogItem(movie.getName(), movie.getMovieId(), s.getRating());
	                                })
	                                .collect(Collectors.toList());
	    return rating;
		
	}
 }
