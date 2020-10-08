/**
 * Copyright (C), 2015-2020, 京东
 * FileName: NestedMapBean
 * Author:   codefans
 * Date:     2020/5/30 21:08
 * Description: 嵌套map的bean
 */
package com.codefans.opensource.json.common;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Map;

/**
 *
 * 嵌套map的bean
 *
 * @author codefans
 * @date 2020/05/30 21:08
 * @since 1.0.0
 */
public class NestedMapBean implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 返回码
     */
    private String resultCode;

    /**
     * 返回信息
     */
    private String resultMsg;

    @JsonProperty(value = "data")
    /**
     * 返回数据
     */
    private Map<String, Object> data;

    private Map<String, Map<String, Object>> nestedTwoLayersOfMap;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public Map<String, Map<String, Object>> getNestedTwoLayersOfMap() {
        return nestedTwoLayersOfMap;
    }

    public void setNestedTwoLayersOfMap(Map<String, Map<String, Object>> nestedTwoLayersOfMap) {
        this.nestedTwoLayersOfMap = nestedTwoLayersOfMap;
    }
}