package com.jarvis.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by arungu on 1/17/2016.
 */
@Component
public class Utilities {

    @Value("${jarvis.uploadpath}")
    private String uploadPath;

    public String getAbsoluteSongPath(String songId){
        return uploadPath  + songId;
      //  return vlcPath + uploadPath  + songId;
    }


}
