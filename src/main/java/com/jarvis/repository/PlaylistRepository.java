package com.jarvis.repository;

import com.jarvis.model.Playlist;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by arungu on 1/16/2016.
 */
public interface PlaylistRepository extends CrudRepository<Playlist,Long> {
    public Playlist findFirstById(String id);
}

