package com.nisum.user.web_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController extends ResponseHandle {

    //@Autowired
    //UserService surveyService;

    @GetMapping()
    public String getUserById() {
        return "TEST";
    }

    //@GetMapping("/{id}")
    //public ResponseEntity<User> getUserById(@PathVariable("id") int id) {
    //    return new ResponseEntity<>(surveyService.getUserById(id), HttpStatus.OK);
    //}

    //@PostMapping()
    //public ResponseEntity<?> generateSurveyHistoricAnswer(@Valid @RequestBody SurveyHistoricAnswer surveyHistoricAnswer) {
    //    return new ResponseEntity<>(surveyService.generateSurveyHistoricAnswer(surveyHistoricAnswer), HttpStatus.OK);
    //}
}

