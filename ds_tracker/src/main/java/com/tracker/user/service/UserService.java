package com.tracker.user.service;

import com.tracker.user.model.UserVO;

public interface UserService {

    public String validateUser(UserVO userVO);

    public boolean validateToken(String emailId, String token);
}
