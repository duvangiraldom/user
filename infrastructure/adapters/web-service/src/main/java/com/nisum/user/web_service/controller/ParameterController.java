package com.nisum.user.web_service.controller;

import com.nisum.user.domain.models.Parameter;
import com.nisum.user.service.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/admin/parameters")
@CrossOrigin(origins = "*")
public class ParameterController extends ResponseHandle {

    @Autowired
    ParameterService service;

    @PutMapping
    public ResponseEntity<Map<String, String>> updateParameter(@Valid @RequestBody Parameter parameter) {
        return new ResponseEntity<>(service.updateParameter(parameter), HttpStatus.OK);
    }
}
