package com.jarvis.service;

import com.jarvis.model.Song;
import com.jarvis.pojo.SongInfoPojo;
import com.jarvis.repository.SongRepository;
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


    public void processSongInfoPojo(SongInfoPojo songInfoPojo) throws Exception {


        //Repo insertion
        Song song = new Song();
        song.setSongName(songInfoPojo.getSongName());

        Song insertedSong = songRepository.save(song);
        String fileName = insertedSong.getId();  // We are using id as the fileName in our system.

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

            } catch (Exception e) {
                logger.error(e.toString());

            }
        } else {
            logger.error("File is empty.");
        }
    }


}
