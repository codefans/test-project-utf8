package com.codefans.basicjava.objectcopy;

import com.codefans.basicjava.util.CollectionHelper;
import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author: codefans
 * @Date: 2020-07-12 12:41
 */

public class ShallowCopyTest {

    @Test
    public void basicShallowCopyTest() {

        try {
            ShallowCopyObject shallowCopyObj = new ShallowCopyObject();
            shallowCopyObj.setId(1002L);
            shallowCopyObj.setName("浅拷贝测试对象001");
            Map<String, String> extension = new HashMap<String, String>();
            extension.put("address", "xxx省xxx市xxx区xxx");
            extension.put("省长姓名", "张xx");
            shallowCopyObj.setExtension(extension);
            MemberVariable memberVariable = new MemberVariable();
            memberVariable.setVariableName("成员变量的名字");
            shallowCopyObj.setMemberVariable(memberVariable);

            ShallowCopyObject newShallowCopyObj = (ShallowCopyObject) shallowCopyObj.clone();
            System.out.println("id=" + newShallowCopyObj.getId());
            System.out.println("name=" + newShallowCopyObj.getName());
            CollectionHelper.print(newShallowCopyObj.getExtension());
            System.out.println("memberVariable=" + newShallowCopyObj.getMemberVariable().getVariableName());

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void oldChangeNewChangeTest() {

        try {
            ShallowCopyObject shallowCopyObj = new ShallowCopyObject();
            shallowCopyObj.setId(1002L);
            shallowCopyObj.setAge(23);
            shallowCopyObj.setName("浅拷贝测试对象001");
            Map<String, String> extension = new HashMap<String, String>(2);
            extension.put("address", "xxx省xxx市xxx区xxx");
            extension.put("省长姓名", "张xx");
            shallowCopyObj.setExtension(extension);
            MemberVariable memberVariable = new MemberVariable();
            memberVariable.setVariableName("成员变量的名字");
            shallowCopyObj.setMemberVariable(memberVariable);

            ShallowCopyObject newShallowCopyObj = (ShallowCopyObject) shallowCopyObj.clone();

            /**
             * 改变老对象的值，看看新对象是否也跟着改变
             */
            shallowCopyObj.setId(3002L);
            shallowCopyObj.setAge(34);
            shallowCopyObj.setName("改变后的老对象的名称");
            extension.put("省长姓名", "改变后的省长姓名张xx");
            shallowCopyObj.setExtension(extension);
            memberVariable.setVariableName("改变后的成员变量的名字");
            shallowCopyObj.setMemberVariable(memberVariable);

            /**
             * 输出结果是：id没变，因为id为基础类型
             */
            System.out.println("id=" + newShallowCopyObj.getId());
            /**
             * 输出结果是：name没变，虽然name为包装类型，但是String是不可变类，所以拷贝时也是新生成对象，新分配内存地址
             */
            System.out.println("name=" + newShallowCopyObj.getName());
            /**
             * 输出结果是：age没变，虽然age为包装类型，但是Integer是不可变类，所以拷贝时也是新生成对象，新分配内存地址
             */
            System.out.println("age=" + newShallowCopyObj.getAge());

            /**
             * 输出结果是：值变化了，因为extension是包装类型
             */
            CollectionHelper.print(newShallowCopyObj.getExtension());
            /**
             * 输出结果是：值变化了，因为memberVariable是包装类型
             */
            System.out.println("memberVariable=" + newShallowCopyObj.getMemberVariable().getVariableName());

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }


    }




}
