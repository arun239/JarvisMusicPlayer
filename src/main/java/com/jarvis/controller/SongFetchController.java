package com.jarvis.controller;

import com.jarvis.model.Song;
import com.jarvis.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by arungu on 1/25/2016.
 */
@RestController
public class SongFetchController {

    @Autowired
    SongRepository songRepository;

    @RequestMapping("/SongFetchController")
    public List<Song> allSong(){
        List<Song> songs;
        songs = songRepository.findAllByOrderBySongNameAsc();
        return songs;
    }

}
