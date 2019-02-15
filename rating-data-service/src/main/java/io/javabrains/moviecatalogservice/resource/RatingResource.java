package io.javabrains.moviecatalogservice.resource;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.moviecatalogservice.model.Rating;
import io.javabrains.moviecatalogservice.model.UserRating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingResource {

	@GetMapping("/{movieId}")
	public Rating getrating(@PathVariable("movieId") String movieId){
		return new Rating(movieId, 4);
	}
	
	@GetMapping("/user/{userId}")
	public UserRating getRating(@PathVariable("userId") String movieId){
		UserRating UserRating = new UserRating();
			List<Rating> list = new ArrayList<>();
			list.add( new Rating("1234", 4));
			list.add( new Rating("123", 3));
				UserRating.setUserRating(list);
		return UserRating;
	}
}
