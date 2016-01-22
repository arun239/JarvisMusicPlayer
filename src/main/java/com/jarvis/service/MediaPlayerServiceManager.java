package com.jarvis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by arungu on 1/17/2016.
 */
@Component
public class MediaPlayerServiceManager {
    public static enum PlatformEnum {
        UNIX,   //Mac
        WINDOWS,   //Windows
        LINUX     //Raspberry
    }

    @Autowired
    WindowsMediaPlayerService windowsMediaPlayerService;

    public MediaPlayerService getMediaPlayerService() {
        PlatformEnum platform = getUnderlyingPlatform();
        MediaPlayerService mediaPlayerService = null;
        switch (platform) {
            case WINDOWS:
                mediaPlayerService = this.windowsMediaPlayerService;
            case UNIX:
                break;
            case LINUX:
                break;
        }
        return mediaPlayerService;
    }

    private static PlatformEnum getUnderlyingPlatform() {
        return PlatformEnum.WINDOWS;  // TODO : Take from properties file
    }


}