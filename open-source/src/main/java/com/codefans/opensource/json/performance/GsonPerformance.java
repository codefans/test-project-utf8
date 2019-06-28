package com.codefans.opensource.json.performance;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author: codefans
 * @date: 2018-05-23 08:59
 */
public class GsonPerformance extends AbstractRuntimePerformance {

    private String optType;

    public GsonPerformance(String optType) {
        this.optType = optType;
    }

    public static void main(String[] args) {

        String optType = "toJson";
        GsonPerformance gson = new GsonPerformance(optType);
        gson.runTime();
        gson.costTime();
    }

    public final String FORMAT = "yyyy-MM-dd HH:mm:ss";

    public Gson getGson(){
        return new GsonBuilder().serializeNulls().setDateFormat(FORMAT).create();
    }

    public Gson getNoNullGson(){
        return new GsonBuilder().setDateFormat(FORMAT).create();
    }

    @Override
    public void execute() {

        if("toBean".equalsIgnoreCase(optType)) {
            toBean();
        } else if("toJson".equalsIgnoreCase(optType)) {
            toJson();
        }

    }

    public void toBean() {

        String jsonStr = this.getJsonStr();
        Gson gson = this.getNoNullGson();
        ConvertBean bean = gson.fromJson(jsonStr, ConvertBean.class);
        System.out.println(bean.getId());

    }

    public void toJson() {

        ConvertBean bean = this.getConvertBean();
        Gson gson = this.getNoNullGson();
        String jsonStr = gson.toJson(bean);
        System.out.println("jsonStr:" + jsonStr);


    }

    public void costTime() {
        System.out.println(endTime);
        System.out.println(startTime);
        System.out.println("耗时为:[" + (endTime - startTime) / 1000 + "s]");
    }


}
