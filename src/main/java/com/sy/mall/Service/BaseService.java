package com.sy.mall.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by lilei on 17-4-29.
 */
@Service
public class BaseService<T> {
    @Autowired
    protected Mapper<T> mapper;

    public int save(T entity) {
        return mapper.insert(entity);
    }

    public int delete(T entity) {
        return mapper.deleteByPrimaryKey(entity);
    }

    /**
     * 单表分页查询
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<T> selectPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        //Spring4支持泛型注入
        List<T> list = mapper.select(null);
        return new PageInfo<T>(list);
    }
}
