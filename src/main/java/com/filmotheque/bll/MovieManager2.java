package com.filmotheque.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.filmotheque.bo.Genre;
import com.filmotheque.bo.Movie;
import com.filmotheque.bo.Participant;
import com.filmotheque.dal.IDAOMovie;
import com.filmotheque.ihm.api.v2.ServiceHelper;
import com.filmotheque.ihm.api.v2.ServiceResponse;

@Component
public class MovieManager2 {
	
	// Injecté
	@Autowired
	IDAOMovie daoMovie;
	
	/**
	 * Récupérer tout les films via la DAO
	 * @return
	 */
	public ServiceResponse<List<Movie>> getAllMovies(){
		ServiceResponse<List<Movie>> response = new ServiceResponse<List<Movie>>();
		
		// la donnée
		response.data = daoMovie.findMovies();
		
		// Si vide
		if (response.data.size() == 0) {
			response.code = "203";
			response.message = "La liste des vide";
			
			// logger le service metier
			ServiceHelper.logService(response);
			
			return response;
		}
		// Si error
		if (response.data == null) {
			response.code = "700";
			response.message = "Erreur technique inconnue";
			
			// logger le service metier
			ServiceHelper.logService(response);
			
			return response;
		}
	
		// Si success
		response.code = "202";
		response.message = "Le liste des films à été récupérée avec succès";
		
		// logger le service metier
		ServiceHelper.logService(response);
		
		return response;
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
	public ServiceResponse<List<Participant>> getParticipants(){
		ServiceResponse<List<Participant>> response = new ServiceResponse<List<Participant>>();
		
		// la donnée
		response.data = daoMovie.findParticipants();
		
		// Si vide
		if (response.data.size() == 0) {
			response.code = "203";
			response.message = "La liste des participants vide";
			
			return response;
		}
		// Si error
		if (response.data == null) {
			response.code = "700";
			response.message = "Erreur technique inconnue";
			
			return response;
		}
	
		// Si success
		response.code = "202";
		response.message = "Le liste des participants à été récupérée avec succès";
		
		return response;
	}
	
	public Genre getGenreById(long id) {
		return daoMovie.findGenreById(id);
	}
	
	public Participant getParticipantById(long id) {
		return daoMovie.findParticipantById(id);
	}
	
	/**
	 * Service pour sauvegarder un film
	 * @param movie
	 */
	public void saveMovie(Movie movie) {
		daoMovie.saveMovie(movie);
	}
}
