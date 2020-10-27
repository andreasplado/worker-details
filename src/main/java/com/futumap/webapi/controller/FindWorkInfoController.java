package com.futumap.webapi.controller;

import com.futumap.webapi.dao.entity.UserEntity;
import com.futumap.webapi.service.UserService;
import com.futumap.webapi.util.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class FindWorkInfoController {

    private static final String USER_STATE = "user-state";
    private static final String LOGGED_IN = "logged-in";
    private static final String LOGGED_OUT = "logged-out";

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody UserEntity userEntity, HttpServletResponse response) {
        if (userService.existsByGoogleAccountId(userEntity.getGoogleAccountId())) {
            Cookie cookie = new Cookie(USER_STATE, LOGGED_IN);
            cookie.setSecure(true);
            response.addCookie(cookie);
            return "index";
        } else {
            userService.save(userEntity);
            return "login";
        }

    }

    @GetMapping("/")
    public String main(HttpServletRequest request) {
        String value = CookieUtils.getCookieValue(request, USER_STATE);
        if(value != null) {
            if (value.equals(LOGGED_IN)) {
                return "index";
            } else {
                return "login";
            }
        }else{
            return "login";
        }
    }


    @RequestMapping("/my_profile")
    public String myProfile() {
        return "my_profile";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletResponse response) {
        Cookie cookie = new Cookie(USER_STATE, LOGGED_IN);
        cookie.setMaxAge(0);
        return "main";
    }
}
