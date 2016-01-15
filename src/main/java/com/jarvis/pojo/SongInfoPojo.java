package com.jarvis.pojo;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by arungu on 1/16/2016.
 */
public class SongInfoPojo {

    private String songName;
    private String userName;
    private String language;
    private String genre;
    private MultipartFile file;



    public SongInfoPojo(String songName, String userName, String language, String genre, MultipartFile file) {
        this.songName = songName;
        this.userName = userName;
        this.language = language;
        this.genre = genre;
        this.file = file;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
