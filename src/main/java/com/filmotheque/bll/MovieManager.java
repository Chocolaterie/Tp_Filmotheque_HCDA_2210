package com.filmotheque.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.filmotheque.bo.Genre;
import com.filmotheque.bo.Movie;
import com.filmotheque.bo.Participant;
import com.filmotheque.dal.IDAOMovie;

@Component
public class MovieManager {
	
	// Injecté
	@Autowired
	IDAOMovie daoMovie;
	
	/**
	 * Récupérer tout les films via la DAO
	 * @return
	 */
	public List<Movie> getAllMovies(){
		// Plus tard tu traitement métier si besoin
		
		// Appeler la dao pour récupérer les données films
		return daoMovie.findMovies();
	}
	
	/**
	 * Récupérer un film via la dao
	 * @param id Id du film
	 * @return
	 */
	public Movie getMovieById(long id){
		return daoMovie.findMovieById(id);
	}
	
	/**
	 * Récupérer la liste des genres
	 * @return
	 */
	public List<Genre> getGenres(){
		return daoMovie.findGenres();
	}
	
	/**
	 * Récupérer la liste des participants
	 * @return
	 */
	public List<Participant> getParticipants(){
		return daoMovie.findParticipants();
	}
}
