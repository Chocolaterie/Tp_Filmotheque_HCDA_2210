package com.filmotheque.dal.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.filmotheque.bo.Avis;
import com.filmotheque.bo.Genre;
import com.filmotheque.bo.Movie;
import com.filmotheque.bo.Participant;
import com.filmotheque.dal.IDAOMovie;

@Profile("jpa")
@Component
public class DAOMovieJpa implements IDAOMovie {

	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	GenreRepository genreRepository;
	
	@Autowired
	ParticipantRepository participantRepository;
	
	@Override
	public List<Movie> findMovies() {
		return (List<Movie>) movieRepository.findAll();
	}

	@Override
	public Movie findMovieById(long id) {
		return movieRepository.findById(id).get();
	}

	@Override
	public List<Genre> findGenres() {
		return (List<Genre>) genreRepository.findAll();
	}

	@Override
	public List<Participant> findParticipants() {
		return (List<Participant>) participantRepository.findAll();
	}

	@Override
	public Genre findGenreById(long id) {
		return genreRepository.findById(id).get();
	}

	@Override
	public Participant findParticipantById(long id) {
		return participantRepository.findById(id).get();
	}

	@Override
	public void saveMovie(Movie film) {
		movieRepository.save(film);
	}

	@Override
	public String findMovieTitleById(long id) {
		return findMovieById(id).getTitle();
	}

	@Override
	public void saveAvis(Avis avis, long idMovie) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<Avis> findAllAvis(long idMovie) {
		return new ArrayList<Avis>();
	}

}
