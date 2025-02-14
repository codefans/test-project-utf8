package com.codefans.practicetask.topologygraph;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * 图节点
 * @Author: codefans
 * @Date: 2025-02-12 20:02
 */
@Data
public class GraphNode {

    /**
     * 节点id-存放服务名称, 例如loan-app-gateway
     */
    private String id;

    /**
     * 节点名称-存放服务描述, 例如贷款应用网关
     */
    private String name;

    /**
     *  节点大小
     */
    private int symbolSize;

    /**
     * 节点样式
     */
    private JSONObject itemStyle;

    /**
     * 节点标签样式
     */
    private JSONObject label;

    public GraphNode(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
