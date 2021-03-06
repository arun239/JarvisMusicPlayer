package com.jarvis.repository;

import com.jarvis.model.Playlist;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by arungu on 1/16/2016.
 */
public interface PlaylistRepository extends CrudRepository<Playlist,Long> {
    public Playlist findFirstById(String id);
    public List<Playlist> findAllByOrderByPlaylistNameAsc();
    public List<Playlist> findByUser_UserEmail(String userEmail);
}

