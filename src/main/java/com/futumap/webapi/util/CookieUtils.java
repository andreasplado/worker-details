package com.futumap.webapi.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Optional;

public class CookieUtils {

    public static String getCookieValue(HttpServletRequest httpServletRequest, String name) {
        final Cookie[] cookies = httpServletRequest.getCookies();
        if(cookies == null) return null; // avoids if blocks
        return Arrays.stream(cookies)
                .filter(e -> name.equals(e.getName()))
                .findAny()
                .map(Cookie::getValue)
                .orElse(null);
    }
}
