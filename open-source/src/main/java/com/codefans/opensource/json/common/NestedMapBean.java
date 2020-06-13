/**
 * Copyright (C), 2015-2020, 京东
 * FileName: NestedMapBean
 * Author:   caishengzhi
 * Date:     2020/5/30 21:08
 * Description: 嵌套map的bean
 */
package com.codefans.opensource.json.common;


import java.io.Serializable;
import java.util.Map;

/**
 *
 * 嵌套map的bean
 *
 * @author caishengzhi
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