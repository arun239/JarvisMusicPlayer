package com.jarvis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by arungu on 1/16/2016.
 */

@Entity
public class Playlist extends BaseEntity {

    @Column
    private String playlistName;

    @Column
    private  String playlistDescription;

    @ManyToOne(optional = false, targetEntity = User.class)
    private User user;

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public String getPlaylistDescription() {
        return playlistDescription;
    }

    public void setPlaylistDescription(String playlistDescription) {
        this.playlistDescription = playlistDescription;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
