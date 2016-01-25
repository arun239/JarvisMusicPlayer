package com.jarvis.controller;

import com.jarvis.model.*;
import com.jarvis.repository.*;
import com.jarvis.service.SongUploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by arungu on 1/12/2016.
 */

@RestController
public class SongUploadController {
    private static final Logger logger = LoggerFactory.getLogger(SongUploadController.class);
    String returnStatus = "Song Uploaded Successfully";
    HttpStatus httpStatus = HttpStatus.CREATED;

    @Autowired
    SongUploadService songUploadService;

    @Autowired
    SongRepository songRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PlaylistRepository playlistRepository;

    @RequestMapping(value = "/SongUpload", method = RequestMethod.POST)
    public ResponseEntity<String> songUploadHandler(@RequestParam("songName") String songName,
                                                    @RequestParam("userEmail") String userEmail,
                                                    @RequestParam("language") Song.SongLanguageEnum songLanguage,
                                                    @RequestParam("genre") Song.SongGenreEnum songGenre,
                                                    @RequestParam("playlistId") String playlistId,
                                                    @RequestParam("songFile") MultipartFile songFile) {

        //  SongInfoPojo songInfoPojo = new SongInfoPojo(songName, userEmail, songLanguage, songGenre, playlistId,songFile);

        try {
            User user = userRepository.findFirstByUserEmail(userEmail);
            if (user != null) {

                Playlist playlist = playlistRepository.findFirstById(playlistId);
                if (playlist != null) {

                    Song song = new Song();
                    song.setSongName(songName);
                    song.setUploadedBy(userEmail);
                    song.setPlaylistId(playlistId);
                    song.setSongLanguage(songLanguage);
                    song.setSongGenre(songGenre);
                    songRepository.save(song);

                    String fileName = song.getId();  // We are using id as the fileName in our system.

                    songUploadService.processSongInfo(fileName, songFile);
                } else {
                    returnStatus = "Incorrect playListID.";
                    httpStatus = HttpStatus.PRECONDITION_FAILED;
                    logger.error(returnStatus);
                }
            } else {
                returnStatus = "Incorrect userEmail.";
                httpStatus = HttpStatus.PRECONDITION_FAILED;
                logger.error(returnStatus);
            }
        } catch (IOException e) {
            returnStatus = "IOException occured while uploading song: " + songName;
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            logger.error(returnStatus, e);
        } catch (Exception e) {
            returnStatus = "Exception occured while uploading song: " + songName;
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            logger.error(returnStatus, e);
        }

        return new ResponseEntity<String>(returnStatus, httpStatus);
    }

}
