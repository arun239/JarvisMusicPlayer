package com.jarvis.pojo;

import com.jarvis.model.Playlist;

/**
 * Created by arungu on 1/16/2016.
 */
public class PlaylistInfoPojo {

    private Playlist playlist;
    private String userEmail;

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
