package com.jarvis.repository;


import com.jarvis.model.Genre;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by arungu on 1/16/2016.
 */
public interface GenreRepository extends CrudRepository<Genre,Long> {
}
