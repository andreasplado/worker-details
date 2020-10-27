package com.futumap.webapi.controller;

import com.futumap.webapi.dao.entity.UserEntity;
import com.futumap.webapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FindWorkInfoController {

    @Autowired
    UserService userService;
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String login(@RequestBody UserEntity userEntity) {
        if(userService.existsByGoogleAccountId(userEntity.getGoogleAccountId())){
            return "index";
        }else{
            return "login";
        }

    }
    @RequestMapping("/")
    public String main(){
        return "login";
    }

    @RequestMapping("/my_profile")
    public String myProfile() {
        return "my_profile";
    }
}
