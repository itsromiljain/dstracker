package com.tracker.user.service;

import com.tracker.user.model.User;

public interface UserService {

    public String login(User user);

    public String saveUser(User user);

    public User getUserByEmail(String emailId);

    public boolean validateToken(String emailId, String token);

    public void logout (String emailId);
}
