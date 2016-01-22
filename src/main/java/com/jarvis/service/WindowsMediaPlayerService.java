package com.jarvis.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by arungu on 1/17/2016.
 */
@Component
public class WindowsMediaPlayerService implements MediaPlayerService{
    private static final Logger logger = LoggerFactory.getLogger(WindowsMediaPlayerService.class);

    @Autowired
    Utilities utilities;

    @Autowired
    WindowsUtilities windowsUtilities;

    @Override
    public void songPlay(String songId) {

        logger.info("Playing Song: " + songId);
        String songPath = utilities.getAbsoluteSongPath(songId);
        String vlcPath = windowsUtilities.getAbsoluteVlcPath();
        try {
            String command = vlcPath + " " + songPath;
            logger.info("Executing command : " + command);
            Process process = Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void songPause() {
        Process process = Runtime.getRuntime().exec();

    }

    @Override
    public void songForward() {

    }

    @Override
    public void songBack() {

    }
}
