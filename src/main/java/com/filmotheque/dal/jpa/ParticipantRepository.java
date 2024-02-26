package com.filmotheque.dal.jpa;

import org.springframework.data.repository.CrudRepository;

import com.filmotheque.bo.Participant;

public interface ParticipantRepository extends CrudRepository<Participant, Long>{

}
