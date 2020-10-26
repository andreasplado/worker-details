package com.futumap.webapi.controller;

import com.futumap.webapi.dao.entity.UserEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class FindWorkInfoController {
    @RequestMapping("/")
    public String mainEntry() {
        return "index";
    }
    @RequestMapping("/my_profile")
    public String myProfile() {
        return "my_profile";
    }
}
