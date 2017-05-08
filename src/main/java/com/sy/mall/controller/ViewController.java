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

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @RequiresGuest
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    @RequiresGuest
    public String register() {
        return "register";
    }
}
