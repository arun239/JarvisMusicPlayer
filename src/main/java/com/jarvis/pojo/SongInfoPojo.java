package com.jarvis.pojo;

import com.jarvis.model.Song;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by arungu on 1/16/2016.
 */
public class SongInfoPojo {


    private String songName;
    private String userEmail;
    private Song.SongLanguageEnum songLanguage;
    private Song.SongGenreEnum songGenre;
    private String playlistId;
    private MultipartFile file;



    public SongInfoPojo(String songName, String userEmail, Song.SongLanguageEnum language, Song.SongGenreEnum genre,String playlistId, MultipartFile file) {
        this.songName = songName;
        this.userEmail = userEmail;
        this.songLanguage = language;
        this.songGenre = genre;
        this.playlistId = playlistId;
        this.file = file;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Song.SongLanguageEnum getSongLanguage() {
        return songLanguage;
    }

    public void setSongLanguage(Song.SongLanguageEnum songLanguage) {
        this.songLanguage = songLanguage;
    }

    public Song.SongGenreEnum getSongGenre() {
        return songGenre;
    }

    public void setSongGenre(Song.SongGenreEnum songGenre) {
        this.songGenre = songGenre;
    }

    public String getPlaylistId() { return playlistId; }

    public void setPlaylistId(String playlistId) { this.playlistId = playlistId;}

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
