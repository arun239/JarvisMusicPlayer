package com.jarvis.pojo;

import com.jarvis.model.Genre;
import com.jarvis.model.Language;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by arungu on 1/16/2016.
 */
public class SongInfoPojo {


    private String songName;
    private String userName;
    private Language.SongLanguageEnum songLanguage;
    private Genre.SongGenreEnum songGenre;
    private MultipartFile file;



    public SongInfoPojo(String songName, String userName, Language.SongLanguageEnum language, Genre.SongGenreEnum genre, MultipartFile file) {
        this.songName = songName;
        this.userName = userName;
        this.songLanguage = language;
        this.songGenre = genre;
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

    public Language.SongLanguageEnum getSongLanguage() {
        return songLanguage;
    }

    public void setSongLanguage(Language.SongLanguageEnum songLanguage) {
        this.songLanguage = songLanguage;
    }

    public Genre.SongGenreEnum getSongGenre() {
        return songGenre;
    }

    public void setSongGenre(Genre.SongGenreEnum songGenre) {
        this.songGenre = songGenre;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
