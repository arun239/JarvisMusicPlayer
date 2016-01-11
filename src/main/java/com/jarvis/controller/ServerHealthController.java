package com.jarvis.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by arungu on 1/11/2016.
 */
@RestController
public class ServerHealthController {

    @RequestMapping("/hello")
    public String serverHealthCheck()
    {
        return "Welcome!!";
    }
}