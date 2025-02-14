package com.codefans.practicetask.topologygraph;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections4.CollectionUtils;

import java.io.InputStream;
import java.util.*;

/**
 * @Author: codefans
 * @Date: 2025-02-12 19:28
 */

public class GenerateTopologyGraphJsonString {

    public static void main(String[] args) {
        GenerateTopologyGraphJsonString gtgjs = new GenerateTopologyGraphJsonString();
        gtgjs.generate();
    }

    public void generate() {

        InputStream is = GenerateTopologyGraphJsonString.class.getResourceAsStream("dubbo-register-info.txt");
        Scanner sc = new Scanner(is);
        String line = null;

        Set<String> applicationSet = new HashSet<>();
        List<GraphNode> graphNodeList = new ArrayList<>();
        List<GraphLink> graphLinkList = new ArrayList<>();
        Map<String/*serviceName*/, ServiceInfoDTO> serviceInfoMap = new HashMap<>();
        ServiceInfoDTO serviceInfoDTO = null;
        JSONObject defaultItemStyle = new JSONObject();
        defaultItemStyle.put("color", "#4b8aeb");
        JSONObject defaultNodeLabel = new JSONObject();
        defaultNodeLabel.put("show", true);
        JSONObject defaultLinkLabel = new JSONObject();
        defaultLinkLabel.put("show", true);
        defaultLinkLabel.put("formatter", "10Gbps");
        int defaultSymbolSize = 50;

        String serviceName = null;
        String serviceNamePrefix = "/dubbo/";
        String serviceNameProviderSuffix = "/providers/dubbo";
        String serviceNameConsumerSuffix = "/consumers/consumer";
        String applicationName = null;
        String applicationPrefix = "application%3D";
        String applicationSuffix = "%26";

        while(sc.hasNextLine()) {
            line = sc.nextLine();
            if(line.indexOf(applicationPrefix) > 0 && line.indexOf(applicationSuffix) > 0) {
                applicationName = line.substring(line.indexOf(applicationPrefix) + applicationPrefix.length());
                applicationName = applicationName.substring(0, applicationName.indexOf(applicationSuffix));
                if(!applicationSet.contains(applicationName)) {
                    applicationSet.add(applicationName);
                    GraphNode graphNode = new GraphNode(applicationName, applicationName);
                    graphNode.setSymbolSize(defaultSymbolSize);
                    graphNode.setItemStyle(defaultItemStyle);
                    graphNode.setLabel(defaultNodeLabel);
                    graphNodeList.add(graphNode);
                }
            }

            if(line.indexOf(serviceNameProviderSuffix) > 0) {
                serviceName = line.substring(line.indexOf(serviceNamePrefix) + serviceNamePrefix.length(), line.indexOf(serviceNameProviderSuffix));
                if(serviceInfoMap.containsKey(serviceName)) {
                    serviceInfoDTO = serviceInfoMap.get(serviceName);
                    serviceInfoDTO.setProviderApplicationName(applicationName);
                } else {
                    serviceInfoDTO = new ServiceInfoDTO();
                    serviceInfoDTO.setServiceName(serviceName);
                    serviceInfoDTO.setProviderApplicationName(applicationName);
                    serviceInfoMap.put(serviceName, serviceInfoDTO);
                }
            } else if(line.indexOf(serviceNameConsumerSuffix) > 0) {
                serviceName = line.substring(line.indexOf(serviceNamePrefix) + serviceNamePrefix.length(), line.indexOf(serviceNameConsumerSuffix));
                if(serviceInfoMap.containsKey(serviceName)) {
                    serviceInfoDTO = serviceInfoMap.get(serviceName);
                    serviceInfoDTO.getConsumerApplicationNames().add(applicationName);
                } else {
                    serviceInfoDTO = new ServiceInfoDTO();
                    serviceInfoDTO.setServiceName(serviceName);
                    List<String> consumerApplicationNames = new ArrayList<>();
                    consumerApplicationNames.add(applicationName);
                    serviceInfoDTO.setConsumerApplicationNames(consumerApplicationNames);
                    serviceInfoMap.put(serviceName, serviceInfoDTO);
                }
            }
//            System.out.println(line);
        }

        System.out.println("------------------applicationSet------------------");
        System.out.println("applicationSet: " + applicationSet);
        System.out.println("------------------serviceInfoMap------------------");
        System.out.println("serviceInfoMap: " + JSON.toJSONString(serviceInfoMap));



        Iterator<String> iter = serviceInfoMap.keySet().iterator();
        String serviceNameKey = null;
        String providerApplicationName = null;
        String consumerApplicationName = null;
        while(iter.hasNext()) {
            serviceNameKey = iter.next();
            serviceInfoDTO = serviceInfoMap.get(serviceNameKey);
            providerApplicationName = serviceInfoDTO.getProviderApplicationName();
            List<String> consumerApplicationNames = serviceInfoDTO.getConsumerApplicationNames();
            if(CollectionUtils.isNotEmpty(consumerApplicationNames)) {
                for (int i = 0; i < consumerApplicationNames.size(); i++) {
                    consumerApplicationName = consumerApplicationNames.get(i);
                    GraphLink graphLink = new GraphLink();
                    graphLink.setSource(consumerApplicationName);
                    graphLink.setTarget(providerApplicationName);
                    JSONObject linkLabel = new JSONObject();
                    linkLabel.put("show", true);
                    linkLabel.put("formatter", "10Gbps");
                    graphLink.setLabel(linkLabel);
                    graphLinkList.add(graphLink);
                }
            } else {
                System.out.println("该serviceName=[" + serviceNameKey + "]没有消费者");
            }
        }

        JSONObject topologyGraphJson = new JSONObject();
        topologyGraphJson.put("nodes", graphNodeList);
        topologyGraphJson.put("links", graphLinkList);
        System.out.println("-----------------topologyGraphJson-----------------");
        System.out.println(JSON.toJSONString(topologyGraphJson));

    }
}

