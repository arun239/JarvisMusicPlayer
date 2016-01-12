package com.jarvis.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by arungu on 1/12/2016.
 */

@RestController
public class SongUploadController {

    @RequestMapping(value="/SongUpload", method = RequestMethod.GET)
    public String songUploadInfo() {

        return "Success!!File Uploaded";
    }

    @RequestMapping(value="/SongUpload", method = RequestMethod.POST)
    public String songUploadHandler(@RequestParam("name") String name,
                                    @RequestParam("Song") MultipartFile Song) {

        if (!Song.isEmpty()) {
            try {
                byte[] bytes = Song.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(name)));
                stream.write(bytes);
                stream.close();
                return "You successfully uploaded " + name + "!";
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + name + " because the file was empty.";
        }

    }

}
