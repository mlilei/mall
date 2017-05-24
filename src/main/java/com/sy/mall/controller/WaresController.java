package com.sy.mall.controller;

import com.sy.mall.ResponseResult;
import com.sy.mall.biz.WaresBiz;
import com.sy.mall.pojo.dto.WaresQueryDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by lilei on 2017/5/23.
 */
@RestController
@RequestMapping("/wares")
public class WaresController {
    @Resource
    private WaresBiz waresBiz;

    /**
     * 商品查询
     */
    @RequestMapping(value = "/queryWares", method = RequestMethod.POST)
    public ResponseResult queryWares(WaresQueryDTO waresQueryDTO) {
        return waresBiz.queryWares(waresQueryDTO);
    }

    @RequestMapping(value = "/getWares/{id}", method = RequestMethod.GET)
    public ResponseResult getWares(@PathVariable(required = true) Integer id) throws InvocationTargetException, IllegalAccessException {
        return waresBiz.getWares(id);
    }

}
