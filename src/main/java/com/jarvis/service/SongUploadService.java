package com.jarvis.service;

import com.jarvis.model.*;
import com.jarvis.pojo.SongInfoPojo;
import com.jarvis.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by arungu on 1/16/2016.
 */
@Service
public class SongUploadService {

    private static final Logger logger = LoggerFactory.getLogger(SongUploadService.class);

    @Value("${jarvis.uploadpath}")
    private String uploadPath;        // = "C:/Windows/Temp/JarvisSongCollection/";

    @Autowired
    SongRepository songRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    LanguageRepository languageRepository;

    @Autowired
    GenreRepository genreRepository;

    @Autowired
    PlaylistRepository playlistRepository;


    public String processSongInfoPojo(SongInfoPojo songInfoPojo) throws Exception {


        //Repo insertion


        User user = userRepository.findFirstByUserEmail(songInfoPojo.getUserEmail());
        if (user != null) {

            Playlist playlist = playlistRepository.findFirstById(songInfoPojo.getPlaylistId());
            if (playlist != null) {

                Language language = new Language();
                language.setSongLanguage(songInfoPojo.getSongLanguage());
                languageRepository.save(language);

                Genre genre = new Genre();
                genre.setSongGenre(songInfoPojo.getSongGenre());
                genreRepository.save(genre);

                Song song = new Song();
                song.setSongName(songInfoPojo.getSongName());
                song.setUploadedBy(songInfoPojo.getUserEmail());
                song.setPlaylistId(songInfoPojo.getPlaylistId());
                songRepository.save(song);

                String fileName = song.getId();  // We are using id as the fileName in our system.

                MultipartFile songFile = songInfoPojo.getFile();

                if (!songFile.isEmpty()) {
                    try {
                        byte[] bytes = songFile.getBytes();
                        File file = new File(uploadPath + fileName);
                        // TODO: Extract file format (songFile.getOriginalFileName) and append that in fileName.
                        logger.info("Jarvis: Writing to file: " + file.getAbsolutePath());
                        BufferedOutputStream stream =
                                new BufferedOutputStream(new FileOutputStream(file));
                        stream.write(bytes);
                        stream.close();
                        return "Successfully uploaded song.";

                    } catch (Exception e) {
                        logger.error(e.toString());
                    }
                } else {
                    logger.error("File is empty.");
                }
            } else {
                logger.error("Incorrect playListID.");
            }
        }else {
            logger.error("Incorrect userEmail.");
            return "Incorrect User Email.";
        }
        return "Error";
    }



}
