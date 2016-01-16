package com.jarvis.controller;

import com.jarvis.model.Playlist;
import com.jarvis.model.User;
import com.jarvis.pojo.PlaylistInfoPojo;
import com.jarvis.repository.PlaylistRepository;
import com.jarvis.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by arungu on 1/16/2016.
 */

@RestController
public class PlaylistAddController {

    private static final Logger logger = LoggerFactory.getLogger(PlaylistAddController.class);

    @Autowired
    UserRepository userRepository;
    @Autowired
    PlaylistRepository playlistRepository;

    @RequestMapping(value = "/PlaylistAdd", method = RequestMethod.POST)
    public String playlistAddController(@RequestBody PlaylistInfoPojo playlistInfoPojo)
    {

        String userEmail = playlistInfoPojo.getUserEmail();
        if (userEmail != null) {
            User user = userRepository.findFirstByUserEmail(userEmail);
            if(user != null) {
                Playlist playlist = playlistInfoPojo.getPlaylist();
                playlist.setUser(user);
                playlistRepository.save(playlist);
            } else {
                logger.info("Can't find user with userEmail: " + userEmail);
            }
        } else {
            logger.error("Can't proceed with null userEmail");
        }

        return "Playlist Added Successfully";
    }
}
