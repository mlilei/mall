package com.sy.mall.common.converter;

import com.sy.mall.common.enums.GenderEnum;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by 李磊
 * on 2017/5/13.
 */
public class StringToGenderEnumConverter implements Converter<String, GenderEnum> {
    private static final Logger LOGGER = LoggerFactory.getLogger(StringToGenderEnumConverter.class);

    @Override
    public GenderEnum convert(String s) {
        if (StringUtils.isBlank(s)) {
            return null;
        }
        try {
            Integer integer = Integer.valueOf(s);
            return GenderEnum.codeOf(integer);
        } catch (NumberFormatException e) {
            LOGGER.error("类型转换异常：{},{}", s, GenderEnum.class);
            return null;
        }
    }
}
