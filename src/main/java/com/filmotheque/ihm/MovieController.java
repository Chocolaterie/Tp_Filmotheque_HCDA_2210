package com.filmotheque.ihm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.filmotheque.bll.MovieManager;
import com.filmotheque.bo.Genre;
import com.filmotheque.bo.Movie;
import com.filmotheque.bo.Participant;

import jakarta.validation.Valid;

@Controller
@SessionAttributes({"loggedUser"})
public class MovieController {

	@Autowired
	MovieManager movieManager;
	
	@GetMapping("/")
	public String showMovies() {
		// Afficher la vue
		return "index";
	}
	
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
		// Tester si pas connecté(e)
		if (model.getAttribute("loggedUser") == null) {
			return "redirect:/";
		}
		
		// 1 :: Récupérer l'id en long 
		long id = Long.parseLong(idParam);
		
		// 2 :: Récupérer le film
		Movie movie = movieManager.getMovieById(id);
		
		// 3 :: Envoyer le film dans la vue
		model.addAttribute("movie", movie);
		
		// 4 :: Afficher la vue
		return "show-movie-detail-page";
	}
	
	public void sendOptionsMovieForm(Model model) {
		// -- la liste des genres à afficher dans le select genre
		List<Genre> genres = movieManager.getGenres();
		model.addAttribute("genres", genres);
		
		// -- la liste des participants à afficher dans le select (realisateur/acteurs)
		List<Participant> participants = movieManager.getParticipants();
		model.addAttribute("participants", participants);
	}
	
	@GetMapping("movie-form")
	public String showMovieForm(Model model) {
		// 1 :: Préparer une film vide par défaut
		Movie movie = new Movie();
		
		// 2 : Envoyer le film dans la vue
		model.addAttribute("movie", movie);
		
		// Envoyer dans le formulaire la liste des données à afficher dans les select
		sendOptionsMovieForm(model);
	
		
		// Afficher la vue (donc le formulaire)
		return "movie-form-page";
	}
	
	/**
	 * TODO
	 * @param movie
	 * @return
	 */
	@PostMapping("movie-form")
	public String postMovieForm(@Valid @ModelAttribute("movie") Movie movie, BindingResult bindingResult, Model model) {
		// si erreur on reste sur la page
		if (bindingResult.hasErrors()) {
			
			// Envoyer dans le formulaire la liste des données à afficher dans les select
			sendOptionsMovieForm(model);
			
			return "movie-form-page";
		}

		return "redirect:/movies";
	}
}
