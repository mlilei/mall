package com.sy.mall.controller;


import com.sy.mall.ResponseResult;
import org.apache.shiro.authz.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lilei on 2017/5/2.
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @RequiresAuthentication
    @RequestMapping("/authentication")
    public ResponseResult testAuthentication() {
        return ResponseResult.createSuccessResult("Authentication");
    }

    @RequiresRoles("SUPER_ADMIN")
    @RequestMapping("/roles")
    public ResponseResult testAdmin() {
        return ResponseResult.createSuccessResult("Roles:SUPER_ADMIN");
    }

    @RequiresPermissions("a:a")
    @RequestMapping("/permissions")
    public ResponseResult testPermissions() {
        return ResponseResult.createSuccessResult("Permissions");
    }

}
