package com.filmotheque.dal;

import java.util.List;

import com.filmotheque.bo.Avis;
import com.filmotheque.bo.Genre;
import com.filmotheque.bo.Movie;
import com.filmotheque.bo.Participant;

public interface IDAOMovie {
	
	public List<Movie> findMovies();
	
	public Movie findMovieById(long id);
	
	public List<Genre> findGenres();
	
	public List<Participant> findParticipants();
	
	public Genre findGenreById(long id);
	
	public Participant findParticipantById(long id);
	
	public void saveMovie(Movie film);
	
	public String findMovieTitleById(long id);
	
	public void saveAvis(Avis avis, long idMovie);
	
	public List<Avis> findAllAvis(long idMovie);
}