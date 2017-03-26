package com.sy.mall.dao;

import com.sy.mall.model.User;

/**
 * Created by lilei on 2017/3/27.
 */
public interface UserDao {
    User selectByUsername(String username);
}
