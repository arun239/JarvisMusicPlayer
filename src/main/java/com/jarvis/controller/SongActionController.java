package com.jarvis.controller;

import com.jarvis.service.MediaPlayerActionEnum;
import com.jarvis.service.MediaPlayerService;
import com.jarvis.service.MediaPlayerServiceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by arungu on 1/17/2016.
 */

@RestController
public class SongActionController {
    @Autowired
    MediaPlayerServiceManager mediaPlayerServiceManager;

    @RequestMapping(value = "/SongAction/{id}", method = RequestMethod.GET)
    public String songActionHandler(@PathVariable("id") String songId, @RequestParam String action){

        MediaPlayerActionEnum mediaPlayerAction = MediaPlayerActionEnum.valueOf(action);
        MediaPlayerService mediaPlayerService = mediaPlayerServiceManager.getMediaPlayerService();

        switch (mediaPlayerAction) {
            case PLAY:{
                mediaPlayerService.songPlay(songId);
                break;
            }
            case PAUSE:{
                mediaPlayerService.songPause();
                break;
            }
            case FORWORD:{
                mediaPlayerService.songForward();
                break;
            }
            case BACK:{
                mediaPlayerService.songBack();
                break;
            }

        }
        return "Success";
    }
}
