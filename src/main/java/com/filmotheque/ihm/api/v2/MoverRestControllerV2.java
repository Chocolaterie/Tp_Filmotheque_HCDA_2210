package com.filmotheque.ihm.api.v2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filmotheque.bll.MovieManager2;
import com.filmotheque.bo.Movie;
import com.filmotheque.bo.Participant;

@RestController
@RequestMapping("/api/v2/")
@CrossOrigin
public class MoverRestControllerV2 {

	@Autowired
	MovieManager2 movieManager;
	
	/**
	 * Retourne la liste des films
	 * @return
	 */
	@GetMapping("movies")
	public ServiceResponse<List<Movie>> getAllMovies(){
		return movieManager.getAllMovies();
	}
	
	/**
	 * Retourne la liste des films
	 * @return
	 */
	@GetMapping("participants")
	public ServiceResponse<List<Participant>> geParticipants(){
		return movieManager.getParticipants();
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
