package com.sy.mall.controller;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
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

    @RequestMapping(value = "/404.html", method = RequestMethod.GET)
    public String errorPage() {
        return "404";
    }

    @RequiresAuthentication
    @RequestMapping(value = "/cart.html", method = RequestMethod.GET)
    public String cart() {
        return "cart";
    }

    @RequestMapping(value = "/customerService.html", method = RequestMethod.GET)
    public String customerService() {
        return "customerService";
    }

    @RequestMapping(value = "/head.html", method = RequestMethod.GET)
    public String head() {
        return "head";
    }

    @RequestMapping(value = "/login.html", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/main.html", method = RequestMethod.GET)
    public String main() {
        return "main";
    }


    @RequiresAuthentication
    @RequestMapping(value = "/order.html", method = RequestMethod.GET)
    public String order() {
        return "order";
    }

    @RequestMapping(value = "/refuse.html", method = RequestMethod.GET)
    public String refuse() {
        return "refuse";
    }

    @RequestMapping(value = "/register.html", method = RequestMethod.GET)
    public String register() {
        return "register";
    }


    @RequiresAuthentication
    @RequestMapping(value = "/user.html", method = RequestMethod.GET)
    public String user() {
        return "user";
    }

    @RequiresAuthentication
    @RequestMapping(value = "/userDetail.html", method = RequestMethod.GET)
    public String userDetail() {
        return "userDetail";
    }

    @RequestMapping(value = "/waresDetail.html", method = RequestMethod.GET)
    public String waresDetail() {
        return "waresDetail";
    }

    @RequestMapping(value = "/evaluate.html", method = RequestMethod.GET)
    public String evaluate() {
        return "evaluate";
    }


}
