package com.filmotheque.dal.jpa;

import org.springframework.data.repository.CrudRepository;

import com.filmotheque.bo.Genre;

public interface GenreRepository extends CrudRepository<Genre, Long>{

}
