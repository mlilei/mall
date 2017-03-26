package com.sy.mall.common.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * json工具
 * Created by lei on 2017/3/11.
 */
public final class JsonUtil {

    private static final Gson gson;

    static {
        gson = new GsonBuilder().serializeNulls()         // null 也序列化
                .enableComplexMapKeySerialization()       // 支持Map的key为复杂对象的形式
                .setDateFormat("yyyy-MM-dd HH:mm:ss")     // 时间转化为特定格式 yyyy-MM-dd HH:mm:ss:SSS
                .create();
    }

    public static Gson getGson() {
        return gson;
    }

    public static String toJson(Object object) {
        return gson.toJson(object);
    }
}
