package com.jarvis.repository;

import com.jarvis.model.Song;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by arungu on 1/16/2016.
 */
public interface SongRepository extends CrudRepository<Song, Long> {
    public List<Song> findAllByOrderBySongNameAsc();
}
