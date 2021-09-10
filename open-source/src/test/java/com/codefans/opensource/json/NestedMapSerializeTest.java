/**
 * Copyright (C), 2015-2020, 京东
 * FileName: NestedMapSerializeTest
 * Author:   codefans
 * Date:     2020/5/30 21:36
 * Description: 嵌套map序列化测试
 */
package com.codefans.opensource.json;


import com.codefans.opensource.json.common.NestedMapBean;
import com.codefans.opensource.json.common.NestedMapValueBean;
import com.codefans.opensource.util.JsonUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 嵌套map序列化测试
 * https://www.ibm.com/developerworks/cn/java/jackson-advanced-application/index.html
 *
 * @author codefans
 * @date 2020/05/30 21:36
 * @since 1.0.0
 */
public class NestedMapSerializeTest {

    String dataKey = "dataKey";
    String jsonStr = "";

    @Test
    public void serializeTest() {

//        this.mapSerialize();
//        this.mapDeserialize();

        this.mapNestedListSerialize();
        this.mapNestedListDeserialize();

//        this.nestedMapSerialize();
//        this.nestedMapDeserialize();

    }

    public void mapSerialize() {
        NestedMapValueBean nestedMapValueBean = new NestedMapValueBean();
        nestedMapValueBean.setId(1200L);
        nestedMapValueBean.setName("张三");
        nestedMapValueBean.setAddr("地址1223334444");

        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put(dataKey, nestedMapValueBean);

        jsonStr = JsonUtils.writeValue(dataMap);
        System.out.println(jsonStr);
    }

    public void mapDeserialize() {

//        MapType javaType = JsonUtils.getObjectMapper().getTypeFactory().constructMapType(HashMap.class,String.class,NestedMapValueBean.class);
//        Map<String, Object> dataMap = JsonUtils.readValue(jsonStr, javaType);
//        NestedMapValueBean nestedMapValueBean = (NestedMapValueBean) dataMap.get(dataKey);

        Map<String, NestedMapValueBean> dataMap = JsonUtils.readValue(jsonStr, new TypeReference<Map<String, NestedMapValueBean>>(){});
        NestedMapValueBean nestedMapValueBean = dataMap.get(dataKey);

        System.out.println(nestedMapValueBean.getId());
        System.out.println(nestedMapValueBean.getName());
        System.out.println(nestedMapValueBean.getAddr());

    }

    public void mapNestedListSerialize() {

        Map<String, List<NestedMapValueBean>> mapResult = new HashMap<>();
        List<NestedMapValueBean> list = new ArrayList<>();
        NestedMapValueBean nestedMapValueBean1 = new NestedMapValueBean();
        nestedMapValueBean1.setId(1100L);
        nestedMapValueBean1.setName("张三");
        nestedMapValueBean1.setAddr("地址1111");

        NestedMapValueBean nestedMapValueBean2 = new NestedMapValueBean();
        nestedMapValueBean2.setId(2200L);
        nestedMapValueBean2.setName("李四");
        nestedMapValueBean2.setAddr("地址2222");

        NestedMapValueBean nestedMapValueBean3 = new NestedMapValueBean();
        nestedMapValueBean3.setId(3300L);
        nestedMapValueBean3.setName("王五");
        nestedMapValueBean3.setAddr("地址3333");
        list.add(nestedMapValueBean1);
        list.add(nestedMapValueBean2);
        list.add(nestedMapValueBean3);

        mapResult.put(dataKey, list);
        jsonStr = JsonUtils.writeValue(mapResult);
        System.out.println(jsonStr);

    }

    public void mapNestedListDeserialize() {

        //第二参数是 map 的 key 的类型，第三参数是 map 的 value 的类型
//        MapType javaType = JsonUtils.getObjectMapper().getTypeFactory().constructMapType(HashMap.class,String.class,List.class);
//        Map<String, List<NestedMapValueBean>> nestedMapBean = JsonUtils.readValue(jsonStr, javaType);

        Map<String, List<NestedMapValueBean>> nestedMapBean = JsonUtils.readValue(jsonStr, new TypeReference<Map<String, List<NestedMapValueBean>>>(){});

        List<NestedMapValueBean> dataList = nestedMapBean.get(dataKey);
        for(int i = 0; i < dataList.size(); i ++) {
            NestedMapValueBean nestedMapValueBean = dataList.get(i);
            System.out.println(nestedMapValueBean.getId() + ", " + nestedMapValueBean.getName() + ", " + nestedMapValueBean.getAddr());
        }

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

        NestedMapBean nestedMapBean = JsonUtils.readValue(jsonStr, new TypeReference<NestedMapBean>(){});

        System.out.println(nestedMapBean.getResultCode());
        System.out.println(nestedMapBean.getResultMsg());

        Map<String, Object> dataMap = nestedMapBean.getData();
        NestedMapValueBean nestedMapValueBean = (NestedMapValueBean) dataMap.get(dataKey);
        System.out.println(nestedMapValueBean.getId());
        System.out.println(nestedMapValueBean.getName());
        System.out.println(nestedMapValueBean.getAddr());
    }



}