package com.jarvis.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Created by arungu on 1/11/2016.
 */
@JsonIgnoreProperties({"id"})
@Entity
public class Song extends BaseEntity {

    @Column
    private String songName;

    @Column
    private String uploadedBy;   //Email id of the uploader

    @Column
    private String playlistId;   //System generated ID of playlist model


    public static enum SongLanguageEnum{
        HINDI,
        ENGLISH
    }

    @Column
    @Enumerated(EnumType.STRING)
    private SongLanguageEnum songLanguage;

    public static enum SongGenreEnum {                         //Nested Class because of static keyword
        CLASSICAL,
        SUFI,
        DEVOTIONAL,
        ROCK,
        ROMANCE,
        PARTY,
        RETRO,
        POP,
        WORKOUT
    }

    @Column
    @Enumerated(EnumType.STRING)
    private SongGenreEnum songGenre;



    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(String uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

    public String getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(String playlistId) {
        this.playlistId = playlistId;
    }

    public SongGenreEnum getSongGenre() {
        return songGenre;
    }

    public void setSongGenre(SongGenreEnum songGenre) { this.songGenre = songGenre;}

    public SongLanguageEnum getSongLanguage() {
        return songLanguage;
    }

    public void setSongLanguage(SongLanguageEnum songLanguage) {
        this.songLanguage = songLanguage;
    }
}
