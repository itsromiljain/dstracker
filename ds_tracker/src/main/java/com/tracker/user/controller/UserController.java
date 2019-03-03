package com.tracker.user.controller;

import com.tracker.common.ResourceNotFoundException;
import com.tracker.demand.service.DemandService;
import com.tracker.supply.service.SupplyService;
import com.tracker.user.model.UserVO;
import com.tracker.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private DemandService trackerService;

    @Autowired
    private SupplyService supplyService;

    @GetMapping("/validate")
    public ResponseEntity<String> validateUser(@RequestBody UserVO userVO) {
        try {
            String token = userService.validateUser(userVO);
            return ResponseEntity.ok().body(token);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
