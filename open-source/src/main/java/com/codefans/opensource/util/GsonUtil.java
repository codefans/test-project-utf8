package com.codefans.opensource.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

/**
 * @author caishengzhi
 * @date 2018-04-19 14:43
 */
public class GsonUtil {

    public static final String FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static Gson getGson(){
        return new GsonBuilder().serializeNulls().setDateFormat(FORMAT).create();
    }

    public static Gson getNoNullGson(){
        return new GsonBuilder().setDateFormat(FORMAT).create();
    }

    public static String toJson(Object obj) {
        return getNoNullGson().toJson(obj);
    }

    public static <T> T fromJson(String json, Class<T> classOfT) throws JsonSyntaxException {
        return getNoNullGson().fromJson(json, classOfT);
    }

}
