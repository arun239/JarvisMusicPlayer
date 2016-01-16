package com.jarvis.model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by arungu on 1/11/2016.
 */
@Entity
public class Song extends BaseEntity {

    @Column
    private String songName;

    @Column
    private String uploadedBy;   //Email id of the uploader

    @Column
    private String playlistId;   //System generated ID of playlist model

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
}
