package com.jarvis.model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by arungu on 1/11/2016.
 */
@Entity
public class Genre extends BaseEntity {

    public static enum SongGenreEnum {                         //Nested Class because of static keyword
        Classical,
        Sufi,
        Devotional,
        Rock,
        Romance,
        Party,
        Retro,
        Pop,
        Workout
    }

    @Column(length = 10)
    private SongGenreEnum songGenre;

    public SongGenreEnum getSongGenre() {
        return songGenre;
    }

    public void setSongGenre(SongGenreEnum songGenre) {
        this.songGenre = songGenre;
    }
}
