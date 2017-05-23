package com.sy.mall.common.converter;

import com.sy.mall.common.enums.WaresOrderEnum;
import org.apache.commons.lang.StringUtils;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by 李磊
 * on 2017/5/13.
 */
public class StringToWaresOrderEnumConverter implements Converter<String, WaresOrderEnum> {

    @Override
    public WaresOrderEnum convert(String s) {
        if (StringUtils.isBlank(s)) {
            return null;
        }
        return WaresOrderEnum.codeOf(s);
    }
}
