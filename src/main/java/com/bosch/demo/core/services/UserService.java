package com.bosch.demo.core.services;

import org.springframework.security.core.userdetails.User;

/**
 * Created by Deepak Rai on 20/9/20.
 */
public interface UserService {
    User findOne(String userName);
}
