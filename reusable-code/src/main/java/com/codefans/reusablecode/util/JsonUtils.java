package com.codefans.reusablecode.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author: codefans
 * @date: 2019-08-06 14:57
 */
public class JsonUtils {

    public static JSONObject getJsonObj(String jsonStr) {
        JSONObject jsonObject = JSONObject.fromObject(jsonStr);
        return jsonObject;
    }

    public static JSONArray getJsonArr(String jsonStr) {
        JSONArray jsonArray = JSONArray.fromObject(jsonStr);

        return jsonArray;
    }




}
