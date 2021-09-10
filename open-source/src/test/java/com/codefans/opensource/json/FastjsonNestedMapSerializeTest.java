/**
 * Copyright (C), 2015-2020, 京东
 * FileName: FastjsonNestedMapSerializeTest
 * Author:   codefans
 * Date:     2020/5/31 23:07
 * Description: fastjson嵌套map测试
 */
package com.codefans.opensource.json;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.deserializer.FieldTypeResolver;
import com.codefans.opensource.json.common.NestedMapBean;
import com.codefans.opensource.json.common.NestedMapValueBean;
import com.codefans.opensource.util.JsonUtils;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * fastjson嵌套map测试
 *
 * @author codefans
 * @date 2020/05/31 23:07
 * @since 1.0.0
 */
public class FastjsonNestedMapSerializeTest {

    String dataKey = "dataKey";
    String jsonStr = "";

    @Test
    public void fastjsonSerializeTest() {

        this.nestedMapSerialize();
        this.nestedMapDeserialize();

    }

    public void nestedMapSerialize() {

        NestedMapBean nestedMapBean = new NestedMapBean();

        String resultCode = "1000";
        String resultMsg = "查询数据成功";
        NestedMapValueBean nestedMapValueBean = new NestedMapValueBean();
        nestedMapValueBean.setId(1200L);
        nestedMapValueBean.setName("张三");
        nestedMapValueBean.setAddr("地址1223334444");

        nestedMapBean.setResultCode(resultCode);
        nestedMapBean.setResultMsg(resultMsg);

        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put(dataKey, nestedMapValueBean);

        nestedMapBean.setData(dataMap);

        jsonStr = JsonUtils.writeValue(nestedMapBean);
        System.out.println(jsonStr);

    }

    public void nestedMapDeserialize() {

        //第二参数是 map 的 key 的类型，第三参数是 map 的 value 的类型
//        MapType javaType = JsonUtils.getObjectMapper().getTypeFactory().constructMapType(HashMap.class,String.class,NestedMapValueBean.class);
//        NestedMapBean nestedMapBean = JsonUtils.readValue(jsonStr, javaType);

        FieldTypeResolver fieldTypeResolver = new FieldTypeResolver() {
            @Override
            public Type resolve(Object o, String s) {
                if(s.equals("data")) {
                    return Map.class;
                }
                return null;
            }
        };

        JSONObject nestedMapBean = JSON.parseObject(jsonStr, JSONObject.class, fieldTypeResolver);

//        NestedMapBean nestedMapBean = JsonUtils.readValue(jsonStr, new TypeReference<NestedMapBean>(){});

        System.out.println(nestedMapBean.get("resultCode"));
        System.out.println(nestedMapBean.get("resultMsg"));

        Map<String, NestedMapValueBean> dataMap = (Map<String, NestedMapValueBean>)nestedMapBean.get("data");
        NestedMapValueBean nestedMapValueBean = (NestedMapValueBean) dataMap.get(dataKey);
        System.out.println(nestedMapValueBean.getId());
        System.out.println(nestedMapValueBean.getName());
        System.out.println(nestedMapValueBean.getAddr());
    }

}