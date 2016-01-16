package com.jarvis.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Created by arungu on 1/11/2016.
 */
@Entity
public class Language extends BaseEntity{

    public static enum SongLanguageEnum{
        HINDI,
        ENGLISH
    }

    @Enumerated(EnumType.STRING)
    private SongLanguageEnum songLanguage;

    public SongLanguageEnum getSongLanguage() {
        return songLanguage;
    }

    public void setSongLanguage(SongLanguageEnum songLanguage) {
        this.songLanguage = songLanguage;
    }
}
