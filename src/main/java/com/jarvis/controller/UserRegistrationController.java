package com.jarvis.controller;

import com.jarvis.model.User;
import com.jarvis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by arungu on 1/16/2016.
 */

@RestController
public class UserRegistrationController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/UserRegistration", method = RequestMethod.POST)
    public String  userRegistrationHandler(@RequestBody User user)
    {
        userRepository.save(user);
        return "Successfully Added";
    }
}
