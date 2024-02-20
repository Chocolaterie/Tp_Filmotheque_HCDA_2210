package com.filmotheque.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.filmotheque.bo.Movie;
import com.filmotheque.dal.IDAOMovie;

@Component
public class MovieManager {
	
	// Injecté
	@Autowired
	IDAOMovie daoMovie;
	
	public List<Movie> getAllMovies(){
		// Plus tard tu traitement métier si besoin
		
		// Appeler la dao pour récupérer les données films
		return daoMovie.findMovies();
	}
}
