package com.filmotheque.bo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.Range;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "Le titre est obligatoire")
	private String title;
	
	@Range(min=1900, message = "Année n'est pas valide")
	private int year;
	
	@Range(min=1, message = "Le film n'est pas assez long")
	private int duration;
	
	@NotBlank(message = "Le synopsis est obligatoire")
	private String synopsis;
	
	@ManyToOne
	private Participant realisator;
	
	@ManyToMany
	private List<Participant> actors = new ArrayList<Participant>();
	
	@ManyToOne
	private Genre genre;
	
	@Transient
	private List<Avis> avis = new ArrayList<Avis>();
	
	public Movie(long id, String title, int year, int duration, String synopsis) {
		super();
		this.id = id;
		this.title = title;
		this.year = year;
		this.duration = duration;
		this.synopsis = synopsis;
	}
	
	public Movie() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}
	/**
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}
	/**
	 * @param duration the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}
	/**
	 * @return the synopsis
	 */
	public String getSynopsis() {
		return synopsis;
	}
	/**
	 * @param synopsis the synopsis to set
	 */
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	/**
	 * @return the realisator
	 */
	public Participant getRealisator() {
		return realisator;
	}
	/**
	 * @param realisator the realisator to set
	 */
	public void setRealisator(Participant realisator) {
		this.realisator = realisator;
	}
	/**
	 * @return the actors
	 */
	public List<Participant> getActors() {
		return actors;
	}
	/**
	 * @param actors the actors to set
	 */
	public void setActors(List<Participant> actors) {
		this.actors = actors;
	}
	/**
	 * @return the genre
	 */
	public Genre getGenre() {
		return genre;
	}
	/**
	 * @param genre the genre to set
	 */
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	/**
	 * @return the avis
	 */
	public List<Avis> getAvis() {
		return avis;
	}
	/**
	 * @param avis the avis to set
	 */
	public void setAvis(List<Avis> avis) {
		this.avis = avis;
	}
	
	
}
