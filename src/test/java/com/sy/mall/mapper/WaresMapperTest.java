package com.sy.mall.mapper;

import com.sy.mall.BaseTest;
import com.sy.mall.common.util.JsonUtil;
import com.sy.mall.pojo.Wares;
import com.sy.mall.pojo.dto.WaresQueryDTO;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 李磊
 * on 2017/3/27.
 */
public class WaresMapperTest extends BaseTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(WaresMapperTest.class);

    @Resource
    private WaresMapper waresMapper;

    @Test
    public void test() {
        WaresQueryDTO waresQueryDTO = new WaresQueryDTO();
        waresQueryDTO.setWaresName("米");
        //waresQueryDTO.setScore(1);
        //waresQueryDTO.setPriceHige(new BigDecimal(1000));
        //waresQueryDTO.setPriceLow(new BigDecimal(600));
        waresQueryDTO.setWaresType("手机");
        //waresQueryDTO.setWaresOrderEnum(WaresOrderEnum.PRICE);
        //waresQueryDTO.setDesc(1);
        List<Wares> wares = waresMapper.listWares(waresQueryDTO);
        System.out.println(JsonUtil.toJson(wares));
    }
}
