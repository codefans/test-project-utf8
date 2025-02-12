package com.codefans.practicetask.topologygraph;

import lombok.Data;

/**
 * 图的边
 * @Author: codefans
 * @Date: 2025-02-12 20:02
 */

@Data
public class GraphLink {

    /**
     * 边的源节点
     */
    private String source;

    /**
     * 边的目标节点
     */
    private String target;

    /**
     * 边的格式化字符串
     */
    private String formatter;
}
