package com.jarvis.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Created by arungu on 1/11/2016.
 */
@Entity
public class Genre extends BaseEntity {

    public static enum SongGenreEnum {                         //Nested Class because of static keyword
        CLASSICAL,
        SUFI,
        DEVITIONAL,
        ROCK,
        ROMANCE,
        PARTY,
        RETRO,
        POP,
        WORKOUT
    }

    @Enumerated(EnumType.STRING)
    private SongGenreEnum songGenre;

    public SongGenreEnum getSongGenre() {
        return songGenre;
    }

    public void setSongGenre(SongGenreEnum songGenre) {
        this.songGenre = songGenre;
    }
}
