package com.sy.mall.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by 李磊
 * on 17-4-29.
 */
@Service
public class BaseService<T> {

    protected Mapper<T> mapper;

    public int save(T entity) {
        return mapper.insert(entity);
    }

    public int delete(T entity) {
        return mapper.deleteByPrimaryKey(entity);
    }

    /**
     * 单表分页查询
     */
    public PageInfo<T> selectPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        //Spring4支持泛型注入
        List<T> list = mapper.select(null);
        return new PageInfo<T>(list);
    }

    public void setMapper(Mapper<T> mapper) {
        this.mapper = mapper;
    }
}
