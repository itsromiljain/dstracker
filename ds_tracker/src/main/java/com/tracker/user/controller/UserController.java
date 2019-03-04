package com.tracker.user.controller;

import com.tracker.common.ResourceNotFoundException;
import com.tracker.user.model.User;
import com.tracker.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/login", consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> login(@RequestBody User user) {
        try {
            String token = userService.login(user);
            if(null == token){
                return ResponseEntity.notFound().build();
            }else {
                return ResponseEntity.ok().body(token);
            }

        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping(path = "/register", consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> register(@RequestBody User user) {
        try {
            String emailId = userService.saveUser(user);
            return ResponseEntity.ok().body(emailId);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping(path = "/logout", consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> logout(@RequestBody User user) {
        try {
            userService.logout(user.getEmailId());
            return ResponseEntity.ok().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
