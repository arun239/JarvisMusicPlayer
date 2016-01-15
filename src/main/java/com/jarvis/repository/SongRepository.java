package com.jarvis.repository;

import com.jarvis.model.Song;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by arungu on 1/16/2016.
 */
public interface SongRepository extends CrudRepository<Song, Long> {
}
