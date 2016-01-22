package com.jarvis.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by arungu on 1/17/2016.
 */
@Component
public class WindowsUtilities {

    @Value("${jarvis.vlcpath}")
    private String vlcPath;

    public String getAbsoluteVlcPath(){
        return vlcPath;
    }
}
