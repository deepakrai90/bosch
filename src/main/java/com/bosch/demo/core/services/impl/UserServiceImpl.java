package com.bosch.demo.core.services.impl;

import com.bosch.demo.core.repositories.UserRepository;
import com.bosch.demo.core.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

/**
 * Created by Deepak Rai on 20/9/20.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findOne(String userName) {
        return userRepository.findByUsername(userName);
    }
}
