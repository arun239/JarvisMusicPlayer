package com.jarvis.controller;

import com.jarvis.model.Playlist;
import com.jarvis.model.User;
import com.jarvis.pojo.PlaylistInfoPojo;
import com.jarvis.repository.PlaylistRepository;
import com.jarvis.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> playlistAddController(@RequestBody PlaylistInfoPojo playlistInfoPojo)
    {
        String returnStatus = "Playlist Added Successfully";
        HttpStatus httpStatus = HttpStatus.CREATED;

        String userEmail = playlistInfoPojo.getUserEmail();
        if (userEmail != null) {
            User user = userRepository.findFirstByUserEmail(userEmail);
            if(user != null) {
                Playlist playlist = playlistInfoPojo.getPlaylist();
                playlist.setUser(user);
                playlistRepository.save(playlist);
            } else {
                returnStatus = "Can't find user with userEmail: " + userEmail;
                httpStatus = HttpStatus.PRECONDITION_FAILED;
                logger.info(returnStatus);
            }
        } else {
            returnStatus = "Can't proceed with null userEmail";
            httpStatus = HttpStatus.BAD_REQUEST;
            logger.error(returnStatus);
        }
        return new ResponseEntity<String>(returnStatus, httpStatus);
    }
}
