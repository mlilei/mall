package com.sy.mall.mapper;

import com.sy.mall.pojo.User;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by 李磊
 * on 2017/3/27.
 */
public interface UserMapper extends Mapper<User> {

    /**
     * 批量插入
     */
    int batchInsert(List<User> userList);
}
