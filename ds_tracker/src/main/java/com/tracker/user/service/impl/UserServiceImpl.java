package com.tracker.user.service.impl;

import com.tracker.common.RandomString;
import com.tracker.user.model.User;
import com.tracker.user.repository.UserRepo;
import com.tracker.user.service.UserService;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private StrongPasswordEncryptor strongEncryptor;

    @Override
    public String login(User inUser) {
        User dbUser = getUserByEmail(inUser.getEmailId());
        if(null != dbUser && strongEncryptor.checkPassword(inUser.getPassword(), dbUser.getEncryptedPassword())) {
            // Generate Token
            RandomString randomString = new RandomString();
            String token=randomString.nextString();
            //Update dbUSer with new token
            dbUser.setToken(token);
            userRepo.save(dbUser);
            return token;
        }else {
            return null;
        }
    }

    @Override
    public User getUserByEmail(String emailId){
        Optional<User> optionalUser = userRepo.findByEmailId(emailId);
        return optionalUser.isPresent()? optionalUser.get():null;
    }

    @Override
    public String saveUser(User user) {
        user.setEncryptedPassword(strongEncryptor.encryptPassword(user.getPassword()));
        user.setActive(true);
        User savedUser = userRepo.save(user);
        return savedUser.getEmailId();
    }

    @Override
    public boolean validateToken(String emailId, String token) {
        User dbUser = getUserByEmail(emailId);
        if(null!=dbUser && token.equals(dbUser.getToken()))
            return true;
        else
            return false;
    }

    @Override
    public void logout (String emailId) {
        //Invalidate the token - save the token as null in DB
        User dbUser = getUserByEmail(emailId);
        dbUser.setToken(null);
        userRepo.save(dbUser);
    }

}
