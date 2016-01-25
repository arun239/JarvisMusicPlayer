package com.jarvis.controller;

import com.jarvis.model.User;
import com.jarvis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by arungu on 1/25/2016.
 */
@RestController
public class UserFetchController {

    @Autowired
    UserRepository userRepository;


    @RequestMapping("/UserFetchController")
    public List<User> allUserList() {
        List<User> users;
        users = userRepository.findAllByOrderByUserNameAsc();
        return users;

    }
}

