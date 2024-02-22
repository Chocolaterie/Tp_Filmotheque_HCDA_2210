package com.filmotheque.ihm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.filmotheque.bll.MovieManager;
import com.filmotheque.bo.Genre;

@Component
public class ConverterGenre implements Converter<String, Genre> {

	@Autowired
	MovieManager movieManager;
	
	@Override
	public Genre convert(String source) {
		long id = Long.parseLong(source);
		
		// Récupérer le genre en base
		return movieManager.getGenreById(id);
	}

}
