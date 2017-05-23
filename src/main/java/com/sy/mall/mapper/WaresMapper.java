package com.sy.mall.mapper;

import com.sy.mall.pojo.Wares;
import com.sy.mall.pojo.dto.WaresQueryDTO;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by 李磊
 * on 2017/3/27.
 */
public interface WaresMapper extends Mapper<Wares> {

    List<Wares> listWares(WaresQueryDTO waresQueryDTO);
}
