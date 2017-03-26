package com.sy.mall.model;

import com.sy.mall.common.enums.GenderEnum;
import lombok.Data;

import java.util.Date;

/**
 * Created by lilei on 2017/3/27.
 */
@Data
public class User {
    private int id;
    private String username;
    private String password;
    private String nickname;
    private Date birthday;
    private String phone;
    private String mail;
    private String introduction;
    private GenderEnum gender;
    private Date createTime;
    private Date updateTime;
}
