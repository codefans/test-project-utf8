package com.codefans.opensource.json.performance;

/**
 * @author codefans
 * @date 2018/2/8 21:35
 */
public abstract class AbstractRuntimePerformance {

    PerformanceDomain domain;
    long startTime;
    long endTime;

    public AbstractRuntimePerformance() {

        domain = new PerformanceDomain();
        domain.setId("111111");
        domain.setType("json performance");
        domain.setRuntime(1234);


    }



    public ConvertBean getConvertBean() {
        ConvertBean bean = new ConvertBean();
        bean.setId(1000);
        bean.setUsername("zhangsan");
        bean.setPassword("1234");
        bean.setAddress("地址在。。。");
        bean.setAddress2("在工作中，经常客服端需要和服务端进行通信，目前很多项目都采用JSON的方式进行数据传输，简单的参数可以通过手动拼接JSON字符串，但如果请求的参数过多，采用手动拼接JSON字符串，出错率就非常大了。并且工作效率也特别低。");
        bean.setAddress3("在工作中，经常客服端需要和服务端进行通信，目前很多项目都采用JSON的方式进行数据传输，简单的参数可以通过手动拼接JSON字符串，但如果请求的参数过多，采用手动拼接JSON字符串，出错率就非常大了。并且工作效率也特别低。");
        bean.setAddress4("在工作中，经常客服端需要和服务端进行通信，目前很多项目都采用JSON的方式进行数据传输，简单的参数可以通过手动拼接JSON字符串，但如果请求的参数过多，采用手动拼接JSON字符串，出错率就非常大了。并且工作效率也特别低。");

        return bean;
    }

    public String getJsonStr() {
        return "{\"id\":1000,\"username\":\"zhangsan\",\"password\":\"1234\",\"address\":\"地址在。。。\"}";
    }

    public void runTime() {
        startTime = System.currentTimeMillis();

        this.execute();

        endTime = System.currentTimeMillis();

        System.out.println("cost time:[" + (endTime - startTime) / 1000 + "s]");
    }

    public abstract void execute();

}
