/**
 * Copyright (C), 2015-2020, 京东
 * FileName: SameNameVariablesSerializeTest
 * Author:   codefans
 * Date:     2020/6/8 11:02
 * Description: 同名成员变量序列化问题
 */
package com.codefans.opensource.json;


import com.codefans.opensource.json.common.Address;
import com.codefans.opensource.json.common.UserInfo;
import com.codefans.opensource.util.JsonUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.Test;

/**
 *
 * 同名成员变量序列化问题
 *
 * @author codefans
 * @date 2020/06/08 11:02
 * @since 1.0.0
 */
public class SameNameVariablesSerializeTest {

    String dataKey = "dataKey";
    String jsonStr = "";

    @Test
    public void serializeTest() {

//        this.serialize();
        this.deserialize();

    }

    public void serialize() {
        UserInfo userInfo = new UserInfo();
        Address address = new Address();
        address.setId(2L);
        address.setAddress("xxx省xxx市xxx区xxx街道xxx号201");
        address.setPostcode("100001");

        userInfo.setId(3L);
        userInfo.setName("张三");
        userInfo.setAddress(address);

        jsonStr = JsonUtils.writeValue(userInfo);
        System.out.println("jsonStr:");
        System.out.println(jsonStr);

    }

    public void deserialize() {

        jsonStr = "{\"id\":3,\"address\":{\"id\":2,\"address\":\"xxx省xxx市xxx区xxx街道xxx号201\",\"postcode\":\"100001\"},\"name\":\"张三\"}";
        UserInfo userInfo = JsonUtils.readValue(jsonStr, new TypeReference<UserInfo>() {
        });
        System.out.println("userId=" + userInfo.getId() + ", name=" + userInfo.getName());
        Address address = userInfo.getAddress();
        System.out.println("addrId=" + address.getId() + ", postcode=" + address.getPostcode() + ", address=" + address.getAddress());
    }

}