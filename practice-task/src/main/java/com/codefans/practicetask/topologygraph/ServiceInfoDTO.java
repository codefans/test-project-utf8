package com.codefans.practicetask.topologygraph;

import lombok.Data;

import java.util.List;

/**
 * @Author: codefans
 * @Date: 2025-02-13 9:01
 */
@Data
public class ServiceInfoDTO {
    /**
     * 服务名称
     */
    private String serviceName;
    /**
     * 提供者应用名称
     */
    private String providerApplicationName;
    /**
     * 消费者应用名称列表
     */
    private List<String> consumerApplicationNames;
}
