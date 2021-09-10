package com.codefans.opensource.json.performance;

import com.codefans.opensource.util.JsonUtils;

/**
 * @author: codefans
 * @date: 2018-05-23 08:58
 */
public class JacksonPerformance extends AbstractRuntimePerformance {

    public JacksonPerformance() {

    }

    public static void main(String[] args) {
        JacksonPerformance jackson = new JacksonPerformance();
        jackson.runTime();
        jackson.costTime();
    }

    @Override
    public void execute() {

        ConvertBean bean = this.getConvertBean();
        String jsonStr = JsonUtils.writeValue(bean);
        System.out.println("jsonStr:" + jsonStr);
    }

    public void costTime() {
        System.out.println(endTime);
        System.out.println(startTime);
        System.out.println("耗时为:[" + (endTime-startTime)/1000 + "s]");
    }

}
