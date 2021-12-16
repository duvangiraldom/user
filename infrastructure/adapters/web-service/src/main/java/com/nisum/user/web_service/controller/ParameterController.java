package com.nisum.user.web_service.controller;

import com.nisum.user.domain.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/admin/password")
@CrossOrigin(origins = "*")
public class PasswordController {

    @PutMapping
    public ResponseEntity<User> updatePasswordPattern(@Valid @RequestBody User user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.OK);
    }
}
