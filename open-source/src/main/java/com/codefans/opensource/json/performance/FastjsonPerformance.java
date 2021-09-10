package com.codefans.opensource.json.performance;

import com.alibaba.fastjson.JSON;

/**
 * @author: codefans
 * @date: 2018-05-23 08:58
 */
public class FastjsonPerformance extends AbstractRuntimePerformance {

    @Override
    public void execute() {

        PerformanceDomain domain = new PerformanceDomain();
        domain.setPropertyName01("2020-04-12 12:00:00.000");
        domain.setPropertyName02("\"1970-01-01 00:00:00.000");
        System.out.println(JSON.toJSON(domain));

    }

    public void toBean() {

    }

    public void toJson() {

    }
}
