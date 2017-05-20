package com.sy.mall.controller;

import org.apache.shiro.authz.annotation.RequiresGuest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by 李磊
 * on 2017/5/2.
 */
@Controller
public class ViewController {

    @RequestMapping(value = "/login.html", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/register.html", method = RequestMethod.GET)
    public String register() {
        return "register";
    }

    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/main.html", method = RequestMethod.GET)
    public String main() {
        return "main";
    }

    @RequestMapping(value = "/user.html", method = RequestMethod.GET)
    public String user() {
        return "user";
    }
}
