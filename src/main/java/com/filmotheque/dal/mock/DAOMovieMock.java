package com.filmotheque.dal.mock;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.filmotheque.bo.Avis;
import com.filmotheque.bo.Genre;
import com.filmotheque.bo.Member;
import com.filmotheque.bo.Movie;
import com.filmotheque.bo.Participant;
import com.filmotheque.dal.IDAOMovie;

@Profile("mock")
@Component
public class DAOMovieMock implements IDAOMovie {

	// Attributs statiques pour gérer les valeurs à afficher et simuler les données
	// en base
	private static List<Movie> lstMovies = new ArrayList<>();
	private static List<Genre> lstGenres = new ArrayList<>();
	private static List<Participant> lstParticipants = new ArrayList<>();
	private static int indexMovies = 1;
	private static int indexAvis = 2;

	// Représente la table en base de données des genres des films
	private static final String[] genres = { "Animation", "Science-fiction", "Documentaire", "Action", "Comédie",
			"Drame" };

	public DAOMovieMock() {
		simulationCoucheDALetDB();
	}

	@Override
	public List<Movie> findMovies() {
		return lstMovies;
	}

	/**
	 * @return film si id correspond
	 * @return null si inconnu
	 */
	@Override
	public Movie findMovieById(long id) {
		return lstMovies.stream().filter(item -> item.getId() == id).findAny().orElse(null);
	}

	@Override
	public List<Genre> findGenres() {
		return lstGenres;
	}

	@Override
	public List<Participant> findParticipants() {
		return lstParticipants;
	}

	@Override
	public Genre findGenreById(long id) {
		return lstGenres.stream().filter(item -> item.getId() == id).findAny().orElse(null);
	}

	/**
	 * @return participant si id correspond
	 * @return null si inconnu
	 */
	@Override
	public Participant findParticipantById(long id) {
		return lstParticipants.stream().filter(item -> item.getId() == id).findAny().orElse(null);
	}

	@Override
	public void saveMovie(Movie film) {
		// Sauvegarde du film
		film.setId(indexMovies++);
		lstMovies.add(film);
	}

	/**
	 * Cette méthode permet de simuler le stockage en base de données et la remontée
	 * d'information
	 */
	public void simulationCoucheDALetDB() {
		// Création de la liste des genres
		for (int index = 0; index < genres.length; index++) {
			lstGenres.add(new Genre(index + 1, genres[index]));
		}

		// Création de la liste des participants aux films (acteurs et réalisateurs)
		// 3 réalisateurs dont 1 pour 2 films et 1 réalisateurs qui est aussi un acteur
		lstParticipants.add(new Participant(1, "Spielberg", "Steven"));
		lstParticipants.add(new Participant(2, "Cronenberg", "David"));
		lstParticipants.add(new Participant(3, "Boon", "Dany"));

		// 2 acteurs par film et l'un d'eux dans 2 films
		lstParticipants.add(new Participant(4, "Attenborough", "Richard"));
		lstParticipants.add(new Participant(5, "Goldblum", "Jeff"));
		lstParticipants.add(new Participant(6, "Davis", "Geena"));
		lstParticipants.add(new Participant(7, "Rylance", "Mark"));
		lstParticipants.add(new Participant(8, "Barnhill", "Ruby"));
		lstParticipants.add(new Participant(9, "Merad", "Kad"));

		// Création de la liste de films
		// 4 films
		Movie jurassicPark = new Movie(indexMovies++, "Jurassic Park", 1993, 128,
				"Le film raconte l'histoire d'un milliardaire et son équipe de généticiens parvenant à ramener à la vie des dinosaures grâce au clonage.");
		jurassicPark.setGenre(lstGenres.get(1));
		jurassicPark.setRealisator(findParticipantById(1));
		// Associer les acteurs
		jurassicPark.getActors().add(findParticipantById(4));
		jurassicPark.getActors().add(findParticipantById(5));
		lstMovies.add(jurassicPark);

		Movie theFly = new Movie(indexMovies++, "The Fly", 1986, 95,
				"Il s'agit de l'adaptation cinématographique de la nouvelle éponyme de l'auteur George Langelaan.");
		theFly.setGenre(lstGenres.get(1));
		theFly.setRealisator(findParticipantById(2));
		// Associer les acteurs
		theFly.getActors().add(findParticipantById(5));
		theFly.getActors().add(findParticipantById(6));
		lstMovies.add(theFly);

		Movie theBFG = new Movie(indexMovies++, "The BFG", 2016, 117,
				"Le Bon Gros Géant est un géant bien différent des autres habitants du Pays des Géants.");
		theBFG.setGenre(lstGenres.get(4));
		theBFG.setRealisator(findParticipantById(1));
		// Associer les acteurs
		theBFG.getActors().add(findParticipantById(7));
		theBFG.getActors().add(findParticipantById(8));
		lstMovies.add(theBFG);

		Movie bienvenueChezLesChtis = new Movie(indexMovies++, "Bienvenue chez les Ch'tis", 2008, 106,
				"Philippe Abrams est directeur de la poste de Salon-de-Provence. Il est marié à Julie, dont le caractère dépressif lui rend la vie impossible. Pour lui faire plaisir, Philippe fraude afin d'obtenir une mutation sur la Côte d'Azur. Mais il est démasqué: il sera muté à Bergues, petite ville du Nord.");
		bienvenueChezLesChtis.setGenre(lstGenres.get(4));
		bienvenueChezLesChtis.setRealisator(findParticipantById(3));
		// Associer les acteurs
		bienvenueChezLesChtis.getActors().add(findParticipantById(3));
		bienvenueChezLesChtis.getActors().add(findParticipantById(9));
		lstMovies.add(bienvenueChezLesChtis);

		// Création d'un membre et un avis
		Member membre1 = new Member(1, "Baille", "Anne-Lise", "abaille@campus-eni.fr", "", false);
		Avis avis = new Avis(1, 4, "On rit du début à la fin", membre1);
		bienvenueChezLesChtis.getAvis().add(avis);
	}

	@Override
	public String findMovieTitleById(long id) {
		Movie film = findMovieById(id);
		if (film != null)
			return film.getTitle();
		return null;
	}

	@Override
	public void saveAvis(Avis avis, long idMovie) {
		Movie filmSelectionne = findMovieById(idMovie);
		if (filmSelectionne != null) {
			avis.setId(indexAvis++);
			filmSelectionne.getAvis().add(avis);
		}
	}

	@Override
	public List<Avis> findAllAvis(long idMovie) {
		Movie filmSelectionne = findMovieById(idMovie);
		return filmSelectionne.getAvis();
	}
}
