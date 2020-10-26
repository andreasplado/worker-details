package com.futumap.webapi.controller;

import com.futumap.webapi.dao.entity.UserEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {
    @GetMapping
    public String index() {
        return "index";
    }
    @GetMapping
    public String myProfile() {
        return "my_profile";
    }
}
