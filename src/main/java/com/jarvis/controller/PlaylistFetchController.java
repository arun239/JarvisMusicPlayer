package com.jarvis.controller;

import com.jarvis.model.Playlist;
import com.jarvis.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by arungu on 1/25/2016.
 */
@RestController
public class PlaylistFetchController {

    @Autowired
    PlaylistRepository playlistRepository;

    @RequestMapping("/PlaylistFetchController")
    public List<Playlist> allPlaylist(){
        List<Playlist> playlists;
        playlists = playlistRepository.findAllByOrderByPlaylistNameAsc();
        return playlists;
    }

}
