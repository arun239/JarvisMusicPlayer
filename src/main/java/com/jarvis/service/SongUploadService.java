package com.jarvis.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by arungu on 1/16/2016.
 */
@Service
public class SongUploadService {

    private static final Logger logger = LoggerFactory.getLogger(SongUploadService.class);

    @Autowired
    Utilities utilities;

    public void processSongInfo(String fileName, MultipartFile songFile) throws IOException {

            byte[] bytes = songFile.getBytes();
            File file = new File(utilities.getUploadPath(fileName));
            // TODO: Extract file format (songFile.getOriginalFileName) and append that in fileName.
            logger.info("Jarvis: Writing to file: " + file.getAbsolutePath());
            BufferedOutputStream stream =
                    new BufferedOutputStream(new FileOutputStream(file));
            stream.write(bytes);
            stream.close();


    }
}
