package com.filmotheque.dal.jpa;

import org.springframework.data.repository.CrudRepository;

import com.filmotheque.bo.Movie;

public interface MovieRepository extends CrudRepository<Movie, Long>{

}
