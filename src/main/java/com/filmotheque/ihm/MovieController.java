package com.filmotheque.ihm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.filmotheque.bll.MovieManager;
import com.filmotheque.bo.Movie;

@Controller
public class MovieController {

	@Autowired
	MovieManager movieManager;
	
	@GetMapping("movies")
	public String showMovies(Model model) {
		// 1 :: Récupérer les données via le service/bll/manager
		List<Movie> movies = movieManager.getAllMovies();
		
		// 2 :: Envoyer ces données dans la vue
		model.addAttribute("movies", movies);
		
		// 3 :: Afficher la vue
		return "show-movies-page";
	}
	
	@GetMapping("movie/{id}")
	public String showMovieDetail(@PathVariable("id") String idParam, Model model) {
		// 1 :: Récupérer l'id en long 
		long id = Long.parseLong(idParam);
		
		// 2 :: Récupérer le film
		Movie movie = movieManager.getMovieById(id);
		
		// 3 :: Envoyer le film dans la vue
		model.addAttribute("movie", movie);
		
		// 4 :: Afficher la vue
		return "show-movie-detail-page";
		
	}
}
