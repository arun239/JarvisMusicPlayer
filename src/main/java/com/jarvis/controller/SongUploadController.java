package com.jarvis.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by arungu on 1/12/2016.
 */

@RestController
public class SongUploadController {
    private static final Logger logger = LoggerFactory.getLogger(SongUploadController.class);

    @RequestMapping(value="/SongUpload", method = RequestMethod.GET)
    public String songUploadInfo() {

        return "Success!!File Uploaded";
    }

    @RequestMapping(value="/SongUpload", method = RequestMethod.POST)

    public String songUploadHandler(@RequestParam("name") String name,
                                    @RequestParam("Song") MultipartFile Song) {

        if (!Song.isEmpty()) {
            try {
                logger.info("Checkpoint - 1");
                byte[] bytes = Song.getBytes();
                logger.info("Checkpoint - 2");
                File file = new File("C:/" + Song.getOriginalFilename());
                logger.info("Checkpoint - 2.5");
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(file));
                logger.info("Checkpoint - 3");
                stream.write(bytes);
                stream.close();
                return "You successfully uploaded " + name + "!";
            } catch (Exception e) {
                logger.error(e.toString());
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + name + " because the file was empty.";
        }

    }

}
