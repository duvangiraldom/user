package com.nisum.user.web_service.controller;

import com.nisum.user.domain.models.User;
import com.nisum.user.service.UserService;
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
    public String getUserById() {
        return "TEST";
    }

    //@GetMapping("/{id}")
    //public ResponseEntity<User> getUserById(@PathVariable("id") int id) {
    //    return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    //}

    @PostMapping()
    public ResponseEntity<?> saveUser(@Valid @RequestBody User user) {
        return new ResponseEntity<String>(userService.saveUser(user), HttpStatus.OK);
    }
}

