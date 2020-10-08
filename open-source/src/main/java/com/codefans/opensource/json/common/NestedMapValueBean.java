/**
 * Copyright (C), 2015-2020, 京东
 * FileName: NestedMapValueBean
 * Author:   codefans
 * Date:     2020/5/30 21:10
 * Description: 嵌套map的value
 */
package com.codefans.opensource.json.common;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 *
 * 嵌套map的value
 *
 * @author codefans
 * @date 2020/05/30 21:10
 * @since 1.0.0
 */
public class NestedMapValueBean implements Serializable {

    /**
     * 注解ID
     */
    @JsonProperty(value = "id")
    private long id;

    /**
     * 名称
     */
    @JsonProperty(value = "name")
    private String name;

    /**
     * 地址
     */
    @JsonProperty(value = "addr")
    private String addr;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}