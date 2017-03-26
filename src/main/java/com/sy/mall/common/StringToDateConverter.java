package com.sy.mall.common;

import org.apache.commons.lang.StringUtils;
import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lilei on 2017/3/21.
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
                format = new SimpleDateFormat("yyyyMMddHHmmss");
                date = format.parse(source.trim());
            } catch (Exception e1) {
                try {
                    format = new SimpleDateFormat("yyyy-MM-dd");
                    date = format.parse(source.trim());
                } catch (Exception e2) {
                }
            }
        }
        return date;
    }
}
