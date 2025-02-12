package com.codefans.practicetask.topologygraph;

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
        List<GraphNode> graphLinkList = new ArrayList<>();

        String serviceName = null;
        String serviceNamePrefix = "/dubbo/";
        String serviceNameSuffix = "/providers/dubbo";
        String serviceNameSuffix2 = "/consumers/consumer";
        String applicationName = null;
        String applicationPrefix = "application%3D";
        String applicationSuffix = "%26dispatcher";
        while(sc.hasNextLine()) {
            line = sc.nextLine();
            applicationName = line.substring(line.indexOf(applicationPrefix) + applicationPrefix.length(), line.indexOf(applicationSuffix));
            if(!applicationSet.contains(applicationName)) {
                applicationSet.add(applicationName);
                GraphNode graphNode = new GraphNode(applicationName, applicationName);
                graphNodeList.add(graphNode);
            }
            if(line.indexOf(serviceNameSuffix) > 0) {
                serviceName = line.substring(line.indexOf(serviceNamePrefix) + serviceNamePrefix.length(), line.indexOf(serviceNameSuffix));
            } else if(line.indexOf(serviceNameSuffix2) > 0) {
                serviceName = line.substring(line.indexOf(serviceNamePrefix) + serviceNamePrefix.length(), line.indexOf(serviceNameSuffix2));
            }
            System.out.println(line);

        }






    }
}

