package com.sy.mall.dao;

import com.sy.mall.model.User;
import tk.mybatis.mapper.common.Mapper;

/**
 * Created by lilei on 2017/3/27.
 */
public interface UserDao extends Mapper<User> {
    User selectByUsername(String username);
}
