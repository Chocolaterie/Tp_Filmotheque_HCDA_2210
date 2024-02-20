package com.filmotheque.ihm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
		return "show-articles-page";
	}
}
