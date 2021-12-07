package com.codefans.reusablecode.designpattern.singleton;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 反序列化破坏单例
 * 怎么破坏单例模式和怎么防止单例模式被破坏
 * http://www.justdojava.com/2019/08/21/Java-single-destroy-prevent/
 *
 * @author: codefans
 * @Date: 2021/12/07 11:10
 * @since: 1.0.0
 */
public class DeserialDestroySingleton {

    public static void main(String[] args) {
        DoubleCheck s1 = null;
        //通过类本身获得实例对象
        DoubleCheck s2 = DoubleCheck.getInstance();
        FileOutputStream fos = null;
        try {
            //序列化到文件中
            fos = new FileOutputStream("SeriableSingleton.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s2);
            oos.flush();
            oos.close();
            //从文件中反序列化为对象
            FileInputStream fis = new FileInputStream("SeriableSingleton.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            s1 = (DoubleCheck) ois.readObject();
            ois.close();
            //对比结果,这里输出的结果为false
            System.out.println(s1 == s2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}