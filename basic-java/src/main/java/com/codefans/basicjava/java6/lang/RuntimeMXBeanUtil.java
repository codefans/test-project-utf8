package com.codefans.basicjava.java6.lang;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

/**
 * @author: codefans
 * @date: 2019-06-04 16:50:12
 */
public class RuntimeMXBeanUtil {

    /**
     * java获取当前进程PID
     * 还可以通过解析jps命令的返回值来获取
     * @return
     */
    public static int getPid() {
        RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
        String name = runtime.getName(); // format: "pid@hostname"
        int pid = -1;
        pid = Integer.parseInt(name.substring(0, name.indexOf('@')));
        System.out.println("name=" + name);
        System.out.println("pid=" + pid);
        return pid;
    }

}
