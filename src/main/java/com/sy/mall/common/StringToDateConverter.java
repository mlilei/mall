package com.sy.mall.common;

import org.apache.commons.lang.StringUtils;
import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 将前段传来的日期转换为Date对象
 * Created by 李磊 on 2017/3/21.
 */
public class StringToDateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        if (StringUtils.isBlank(source)) {
            return null;
        }

        Date date = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            date = format.parse(source.trim());
        } catch (Exception e) {
            try {
                format = new SimpleDateFormat("yyyy-MM-dd");
                date = format.parse(source.trim());
            } catch (Exception e1) {
                try {
                    format = new SimpleDateFormat("MM/dd/yyyy");
                    date = format.parse(source.trim());
                } catch (Exception ignored) {
                }
            }
        }
        return date;
    }
}
