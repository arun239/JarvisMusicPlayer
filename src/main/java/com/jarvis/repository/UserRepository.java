package com.jarvis.repository;

import com.jarvis.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by arungu on 1/16/2016.
 */
public interface UserRepository extends CrudRepository<User,Long> {
    public User findFirstByUserEmail(String userEmail);

    public List<User> findAllByOrderByUserNameAsc();
}
