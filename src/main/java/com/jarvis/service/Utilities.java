package com.jarvis.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.file.FileSystems;

/**
 * Created by arungu on 1/17/2016.
 */
@Component
public class Utilities {

    @Value("${jarvis.playerpath}")
    private String playerPath;

    @Value("${jarvis.uploadpath}")
    private String uploadPath;


    public String getPlayerPath() {
        return playerPath;
    }

    public void setPlayerPath(String playerPath) {
        this.playerPath = playerPath;
    }

    public String getUploadPath(String songId) {
        return uploadPath + FileSystems.getDefault().getSeparator() + songId;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }
}
