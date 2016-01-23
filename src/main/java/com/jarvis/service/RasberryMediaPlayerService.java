package com.jarvis.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by arungu on 1/23/2016.
 */
@Component
public class RasberryMediaPlayerService implements MediaPlayerService {

    private static final Logger logger = LoggerFactory.getLogger(WindowsMediaPlayerService.class);
    private static final String PLAY_COMMAND = "%s --loop -o local %s &";   //'&' sign to run in separate thread


    @Autowired
    Utilities utilities;

    @Override
    public void songPlay(String songId) {

        logger.info("Playing Song: " + songId);
        try {
            String command = String.format(PLAY_COMMAND, utilities.getPlayerPath(), utilities.getUploadPath(songId));
            logger.info("Executing command : " + command);
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void songPause() {

    }

    @Override
    public void songForward() {

    }

    @Override
    public void songBack() {

    }
}
