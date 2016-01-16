package com.jarvis.repository;

import com.jarvis.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by arungu on 1/16/2016.
 */
public interface UserRepository extends CrudRepository<User,Long> {
    public User findFirstByUserEmail(String userEmail);
}
