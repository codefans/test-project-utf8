package com.codefans.opensource.rocketmq;

import com.codefans.opensource.rocketmq.client.Validators;
import org.apache.rocketmq.client.exception.MQClientException;
import org.junit.Test;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

/**
 * @author: codefans
 * @date: 2019-06-04 16:16:40
 */
public class GroupAndTopicNameValidateTest {


    @Test
    public void groupNameValidateTest() {

//        String groupName = "(fdfdf)";//报错
//        String groupName = "^[%|a-zA-Z0-9_-]+$";//报错
//        String groupName = "%|a-zA-Z0-9_-";//正常
//        String groupName = "^dfdfd";//报错
//        String groupName = "[dfdfd";//报错
//        String groupName = "dfdfd]";//报错
//        String groupName = "+dfdfd";
//        String groupName = "$dfdfd";
        String groupName = "#dfdfd";
        try {
            Validators.checkGroup(groupName);
        } catch (MQClientException e) {
            e.printStackTrace();
        }

    }

    /**
     * group名和topic名只能包含'%'、'|'、'_'、'-'四个特殊字符，其他只能是数字和字母
     */
    @Test
    public void topicNameValidateTest() {

        String topicName = "%|_-fdkfdkfdlfd";
        try {
            Validators.checkTopic(topicName);
        } catch (MQClientException e) {
            e.printStackTrace();
        }

        RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
        String name = runtime.getName(); // format: "pid@hostname"
        System.out.println("name=" + name);
        System.out.println("pid=" + Integer.parseInt(name.substring(0, name.indexOf('@'))));


    }


}
