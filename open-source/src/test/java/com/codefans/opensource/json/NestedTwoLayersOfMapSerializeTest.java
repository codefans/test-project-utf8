/**
 * Copyright (C), 2015-2020, 京东
 * FileName: NestedTwoLayersOfMapSerializeTest
 * Author:   codefans
 * Date:     2020/5/30 21:44
 * Description: 嵌套2层map序列化测试
 */
package com.codefans.opensource.json;


import com.codefans.opensource.json.common.NestedMapBean;
import com.codefans.opensource.json.common.NestedMapValueBean;
import com.codefans.opensource.util.JsonUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 嵌套2层map序列化测试
 *
 * @author codefans
 * @date 2020/05/30 21:44
 * @since 1.0.0
 */
public class NestedTwoLayersOfMapSerializeTest {


    String dataKey = "dataKey";
    String innerKey = "innerDataKey";
    String jsonStr = "";

    @Test
    public void serializeTest() {

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

        Map<String, Map<String, Object>> dataMap = new HashMap<>();
        Map<String, Object> innerMap = new HashMap<>();

        innerMap.put(innerKey, nestedMapValueBean);
        dataMap.put(dataKey, innerMap);

        nestedMapBean.setNestedTwoLayersOfMap(dataMap);

        jsonStr = JsonUtils.writeValue(nestedMapBean);
        System.out.println(jsonStr);

    }

    public void nestedMapDeserialize() {

//        String jsonStr = "{\"resultCode\":\"1000\",\"resultMsg\":\"查询数据成功\",\"data\":{\"dataList\":{\"innerDataKey\":{\"id\":1200,\"name\":\"张三\",\"addr\":\"地址1223334444\"}}}}";
//        NestedMapBean nestedMapBean = JsonUtils.readValue(jsonStr, NestedMapBean.class);
        NestedMapBean nestedMapBean = JsonUtils.readValue(jsonStr, new TypeReference<NestedMapBean>() {
        });
        System.out.println(nestedMapBean.getResultCode());
        System.out.println(nestedMapBean.getResultMsg());

        Map<String, Map<String, Object>> dataMap = nestedMapBean.getNestedTwoLayersOfMap();
        Map<String, Object> innerMap = dataMap.get(dataKey);
        NestedMapValueBean nestedMapValueBean = (NestedMapValueBean) innerMap.get(innerKey);
        System.out.println(nestedMapValueBean.getId());
        System.out.println(nestedMapValueBean.getName());
        System.out.println(nestedMapValueBean.getAddr());
    }

}