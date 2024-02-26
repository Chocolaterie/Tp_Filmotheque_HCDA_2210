package com.filmotheque.bo;

import jakarta.persistence.Entity;

@Entity
public class Participant extends Person {

	public Participant() {
		
	}
	
	public Participant(int id, String firstname, String lastname) {
		super(id, firstname, lastname);
	}

}
