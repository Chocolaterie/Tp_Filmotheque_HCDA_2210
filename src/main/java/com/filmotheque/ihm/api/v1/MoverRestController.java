package com.filmotheque.ihm.api.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filmotheque.bll.MovieManager;
import com.filmotheque.bo.Movie;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin
public class MoverRestController {

	@Autowired
	MovieManager movieManager;
	
	/**
	 * Retourne la liste des films
	 * @return
	 */
	@GetMapping("movies")
	public List<Movie> getAllMovies(){
		return movieManager.getAllMovies();
	}
	
	/**
	 * Retourner un film via l'id envoyer en paramètre
	 * @param id
	 * @return
	 */
	@GetMapping("movies/{id}")
	public Movie getMovieById(@PathVariable("id") Long id) {
		return movieManager.getMovieById(id);
	}
}
