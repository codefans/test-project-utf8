package com.codefans.basicjava.jvm;

/**
 * @author: codefans
 * @date: 2019-07-12 15:47
 * 类如何加载和处理
 */
public class ClassLoadingProcedureTest {

    public static void main(String[] args) {
//        System.out.println(T.num);
        System.out.println(TT.num);
//        System.out.println(TTT.num);
    }

}

class T {
//    num定义在这里时，main方法输出T.num的值为：3
    public static int num = 2; //链接准备阶段：num = 0, 初始化initializing阶段：将2赋给num
    public static T t = new T(); //链接准备阶段：t = null, 初始化initializing阶段：执行构造方法T()

    private T() {
        System.out.println("---" + num); //输出2
        num++;
    }

}

class TT {
    public static TT t = new TT(); //链接准备阶段：t = null, 初始化initializing阶段：执行构造方法T()
//    num定义在这里时，main方法输出TT.num的值为：2
    public static int num = 2;//链接准备阶段：num = 0, 初始化initializing阶段：将2赋给num

    private TT() {
        System.out.println("---" + num); //输出0
        num++;
    }

}

class TTT {
    public static TTT t = new TTT(); //链接准备阶段：t = null, 初始化initializing阶段：执行构造方法T()
//    num定义在这里时，main方法输出TT.num的值为：2
    public static int num = 2; //链接准备阶段：num = 0, 初始化initializing阶段：将2赋给num

    private TTT() {
        num++;
        System.out.println("---" + num); //输出1
    }

}

