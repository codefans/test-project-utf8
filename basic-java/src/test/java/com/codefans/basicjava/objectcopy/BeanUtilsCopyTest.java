package com.codefans.basicjava.objectcopy;

import com.codefans.basicjava.util.CollectionHelper;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: codefans
 * @Date: 2020-07-12 13:41
 * 测试commons-beanutils包和spring-beans包下的BeanUtils.copyProperties方法是浅拷贝还是深拷贝
 */

public class BeanUtilsCopyTest {

    /**
     * 测试commons-beanutils包下的BeanUtils.copyProperties方法是浅拷贝还是深拷贝
     * 经过验证，是浅拷贝
     */
    @Test
    public void commonBeanUtilsTest() {

        try {
            DeepCopyObject deepCopyObj = new DeepCopyObject();
            deepCopyObj.setId(1002);
            deepCopyObj.setName("深拷贝测试对象001");
            deepCopyObj.setMoney(10002f);
            List<String> extension = new ArrayList<String>(2);
            extension.add("xxx省xxx市xxx区xxx");
            extension.add("张xx");
            deepCopyObj.setExtension(extension);
            MemberVariable memberVariable = new MemberVariable();
            memberVariable.setVariableName("成员变量的名字");
            deepCopyObj.setMemberVariable(memberVariable);

            DeepCopyObject newDeepCopyObj = new DeepCopyObject();
            BeanUtils.copyProperties(newDeepCopyObj, deepCopyObj);

            /**
             * 改变老对象的值，看看新对象是否也跟着改变
             */
            deepCopyObj.setId(3002);
            deepCopyObj.setMoney(34567f);
            deepCopyObj.setName("改变后的老对象的名称");
            extension.add(1, "改变后的省长姓名张xx");
            deepCopyObj.setExtension(extension);
            memberVariable.setVariableName("改变后的成员变量的名字");
            deepCopyObj.setMemberVariable(memberVariable);

            /**
             * 输出结果是：id没变，因为是深拷贝，重新生成了一个对象，新分配的内存地址
             */
            System.out.println("id=" + newDeepCopyObj.getId());
            /**
             * 输出结果是：name没变，因为是深拷贝，重新生成了一个对象，新分配的内存地址
             */
            System.out.println("name=" + newDeepCopyObj.getName());
            /**
             * 输出结果是：money没变，因为是深拷贝，重新生成了一个对象，新分配的内存地址
             */
            System.out.println("money=" + newDeepCopyObj.getMoney());

            /**
             * 输出结果是：extension变了，说明是浅拷贝
             */
            CollectionHelper.print(newDeepCopyObj.getExtension());
            /**
             * 输出结果是：memberVariable变了，说明是浅拷贝
             */
            System.out.println("memberVariable=" + newDeepCopyObj.getMemberVariable().getVariableName());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 测试spring-beans包下的BeanUtils.copyProperties方法是浅拷贝还是深拷贝
     * 经过验证，是浅拷贝
     */
    @Test
    public void springBeanUtilsTest() {

        try {
            DeepCopyObject deepCopyObj = new DeepCopyObject();
            deepCopyObj.setId(1002);
            deepCopyObj.setName("深拷贝测试对象001");
            deepCopyObj.setMoney(10002f);
            List<String> extension = new ArrayList<String>(2);
            extension.add("xxx省xxx市xxx区xxx");
            extension.add("张xx");
            deepCopyObj.setExtension(extension);
            MemberVariable memberVariable = new MemberVariable();
            memberVariable.setVariableName("成员变量的名字");
            deepCopyObj.setMemberVariable(memberVariable);

            DeepCopyObject newDeepCopyObj = new DeepCopyObject();
            org.springframework.beans.BeanUtils.copyProperties(deepCopyObj, newDeepCopyObj);

            /**
             * 改变老对象的值，看看新对象是否也跟着改变
             */
            deepCopyObj.setId(3002);
            deepCopyObj.setMoney(34567f);
            deepCopyObj.setName("改变后的老对象的名称");
            extension.add(1, "改变后的省长姓名张xx");
            deepCopyObj.setExtension(extension);
            memberVariable.setVariableName("改变后的成员变量的名字");
            deepCopyObj.setMemberVariable(memberVariable);

            /**
             * 输出结果是：id没变，因为是深拷贝，重新生成了一个对象，新分配的内存地址
             */
            System.out.println("id=" + newDeepCopyObj.getId());
            /**
             * 输出结果是：name没变，因为是深拷贝，重新生成了一个对象，新分配的内存地址
             */
            System.out.println("name=" + newDeepCopyObj.getName());
            /**
             * 输出结果是：money没变，因为是深拷贝，重新生成了一个对象，新分配的内存地址
             */
            System.out.println("money=" + newDeepCopyObj.getMoney());

            /**
             * 输出结果是：extension变了，说明是浅拷贝
             */
            CollectionHelper.print(newDeepCopyObj.getExtension());
            /**
             * 输出结果是：memberVariable变了，说明是浅拷贝
             */
            System.out.println("memberVariable=" + newDeepCopyObj.getMemberVariable().getVariableName());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}
