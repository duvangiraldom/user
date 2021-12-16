package com.nisum.user.web_service.controller;

import com.nisum.user.domain.models.User;
import com.nisum.user.service.UserService;
import com.nisum.user.web_service.dto.UserFilterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController extends ResponseHandle {

    @Autowired
    UserService userService;

    @GetMapping()
    public ResponseEntity<User> getUserById(@Valid @RequestBody UserFilterDto filter) {
        return new ResponseEntity<>(userService.getUserByEmail(filter.getEmail()), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<User> saveUser(@Valid @RequestBody User user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.OK);
    }
}

