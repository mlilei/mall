package com.sy.mall.biz;

import com.google.common.base.Preconditions;
import com.sy.mall.ResponseResult;
import com.sy.mall.Service.WaresService;
import com.sy.mall.common.util.CheckParamUtil;
import com.sy.mall.mapper.WaresParameterMapper;
import com.sy.mall.pojo.Wares;
import com.sy.mall.pojo.WaresParameter;
import com.sy.mall.pojo.dto.WaresQueryDTO;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by lilei on 2017/5/23.
 */
@Component
public class WaresBiz {
    private static final Logger LOGGER = LoggerFactory.getLogger(WaresBiz.class);

    @Resource
    private WaresService waresService;
    @Resource
    private WaresParameterMapper waresParameterMapper;

    /**
     * 商品查询
     */
    public ResponseResult queryWares(WaresQueryDTO waresQueryDTO) {
        CheckParamUtil.checkQueryWaresParams(waresQueryDTO);
        List<Wares> waresList = waresService.listWares(waresQueryDTO);
        ResponseResult responseResult = ResponseResult.createSuccessResult();
        responseResult.setData(waresList);
        return responseResult;
    }

    public ResponseResult getWares(Integer waresId) throws IllegalAccessException, InvocationTargetException {

        Preconditions.checkNotNull(waresId, "参数非法");
        Wares wares = waresService.getWares(waresId);
        if (wares == null) {
            return ResponseResult.createSuccessResult();
        }
        WaresParameter waresParameter = new WaresParameter();
        waresParameter.setWaresId(Long.valueOf(waresId));
        List<WaresParameter> waresParameterList = waresParameterMapper.select(waresParameter);

        Map<String, Object> res = new LinkedHashMap<>();
        try {
            res = BeanUtils.describe(wares);
        } catch (NoSuchMethodException e) {
            LOGGER.error("对象到参数转换异常:{}", wares, e);
            e.printStackTrace();
        }
        res.put("parameter", waresParameterList);
        ResponseResult responseResult = ResponseResult.createSuccessResult();
        responseResult.setData(res);
        return responseResult;
    }
}
