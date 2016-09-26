package com.xin.service;

import com.xin.entity.User;
import com.xin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by CHENXINXIN on 2016/8/2.
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUser(Long id){
        User user = userRepository.findOne(id);
        return user;
    }
}
