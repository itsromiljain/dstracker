package com.tracker.user.service.impl;

import com.tracker.user.model.UserVO;
import com.tracker.user.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public String validateUser(UserVO userVO) {
        return null;
    }

    @Override
    public boolean validateToken(String emailId, String token) {
       return true;
    }
}
