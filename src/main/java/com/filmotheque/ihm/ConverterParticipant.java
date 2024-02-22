package com.filmotheque.ihm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.filmotheque.bll.MovieManager;
import com.filmotheque.bo.Participant;

@Component
public class ConverterParticipant implements Converter<String, Participant> {

	@Autowired
	MovieManager movieManager;
	
	@Override
	public Participant convert(String source) {
		long id = Long.parseLong(source);
		
		// Récupérer le genre en base
		return movieManager.getParticipantById(id);
	}

}