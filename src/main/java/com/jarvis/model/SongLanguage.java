package com.jarvis.model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by arungu on 1/11/2016.
 */
@Entity
public class SongLanguage extends BaseEntity{

    public static enum SongLanguageEnum{
        HINDI,
        ENGLISH
    }

    @Column(length = 10)
    private SongLanguageEnum songLanguage;

    public SongLanguageEnum getSongLanguage() {
        return songLanguage;
    }

    public void setSongLanguage(SongLanguageEnum songLanguage) {
        this.songLanguage = songLanguage;
    }
}
