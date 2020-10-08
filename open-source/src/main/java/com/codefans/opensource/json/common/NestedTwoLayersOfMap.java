/**
 * Copyright (C), 2015-2020, 京东
 * FileName: NestedTwoLayersOfMap
 * Author:   codefans
 * Date:     2020/5/30 21:41
 * Description: 嵌套两层map序列化测试
 */
package com.codefans.opensource.json.common;


import java.io.Serializable;
import java.util.Map;

/**
 *
 * 嵌套两层map序列化测试
 *
 * @author codefans
 * @date 2020/05/30 21:41
 * @since 1.0.0
 */
public class NestedTwoLayersOfMap implements Serializable {

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
    private Map<String, Map<String, Object>> data;

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

    public Map<String, Map<String, Object>> getData() {
        return data;
    }

    public void setData(Map<String, Map<String, Object>> data) {
        this.data = data;
    }
}