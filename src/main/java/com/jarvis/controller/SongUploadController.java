package com.jarvis.controller;

import com.jarvis.model.Genre;
import com.jarvis.model.Language;
import com.jarvis.pojo.SongInfoPojo;
import com.jarvis.service.SongUploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by arungu on 1/12/2016.
 */

@RestController
public class SongUploadController {
    private static final Logger logger = LoggerFactory.getLogger(SongUploadController.class);

    @Autowired
    SongUploadService songUploadService;

    @RequestMapping(value="/SongUpload", method = RequestMethod.GET)
    public String songUploadInfo() {

        return "Success!!File Uploaded";
    }

    @RequestMapping(value="/SongUpload", method = RequestMethod.POST)


    public String songUploadHandler(@RequestParam("songName") String songName,
                                    @RequestParam("userName") String userName,
                                    @RequestParam("language") Language.SongLanguageEnum language,
                                    @RequestParam("genre") Genre.SongGenreEnum genre,
                                    @RequestParam("songFile") MultipartFile songFile) {


        SongInfoPojo songInfoPojo = new SongInfoPojo(songName, userName, language, genre, songFile);
        try {
            songUploadService.processSongInfoPojo(songInfoPojo);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.toString());
            return "Error occurred while processing";  // TODO: Add response code.
            // FIXME: Sample FIXME
        }


        return "You successfully uploaded " ;
    }

}
