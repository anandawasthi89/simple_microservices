package com.MSProject.user.controller;

import com.MSProject.user.entities.ResponseObject;
import com.MSProject.user.entities.User;
import com.MSProject.user.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/Users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/")
    public User addUser(@RequestBody User user){

        User u = userService.addUser(user);
        log.info("User is add: "+ u);
        return u;
    }

    @GetMapping(path = "/{userId}")
    public ResponseObject getUserByIdWithItsDepartment(@PathVariable Long userId){

        return userService.getUserByIdWithItsDepartment(userId);
    }

}
