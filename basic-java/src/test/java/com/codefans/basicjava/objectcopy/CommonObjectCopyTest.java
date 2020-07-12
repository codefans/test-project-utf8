package com.codefans.basicjava.objectcopy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author: codefans
 * @Date: 2020-07-12 13:41
 * 常用对象拷贝测试
 */

public class CommonObjectCopyTest {

    /**
     * 数组的clone都是浅拷贝
     * 但是如果数组元素是基础类型或者不可变类型，老数组某个元素的修改，也不会影响到新数组
     */
    @Test
    public void arrayCloneTest() {

        int[] arr = new int[]{
            1,2,3,4,5,6
        };
        int[] newArr = arr.clone();
        arr[1] = 22;
        /**
         * 输出2，因为是基础类型
         */
        System.out.println(newArr[1]);

        MemberVariable[] objArr = new MemberVariable[2];
        MemberVariable memberVariable = new MemberVariable();
        memberVariable.setVariableName("包装类型数组clone测试");
        objArr[0] = memberVariable;
        MemberVariable[] newObjArr = objArr.clone();
        memberVariable.setVariableName("修改后包装类型数组clone测试");
        /**
         * 输出的是修改后的值, 说明是浅拷贝
         */
        System.out.println(newObjArr[0].getVariableName());
    }

    /**
     * 数组使用Arrays.copyOf也是浅拷贝
     * 但是如果数组元素是基础类型或者不可变类型，老数组某个元素的修改，也不会影响到新数组
     */
    @Test
    public void arrayCopyOfTest() {

        int[] arr = new int[]{
                1,2,3,4,5,6
        };
        int[] newArr = Arrays.copyOf(arr, arr.length);
        arr[1] = 22;
        /**
         * 输出2，因为是基础类型
         */
        System.out.println(newArr[1]);

        MemberVariable[] objArr = new MemberVariable[2];
        MemberVariable memberVariable = new MemberVariable();
        memberVariable.setVariableName("包装类型数组clone测试");
        objArr[0] = memberVariable;
        MemberVariable[] newObjArr = Arrays.copyOf(objArr, objArr.length);
        memberVariable.setVariableName("修改后包装类型数组clone测试");
        /**
         * 输出的是修改后的值, 说明是浅拷贝
         */
        System.out.println(newObjArr[0].getVariableName());

    }

    /**
     * 集合的clone是浅拷贝
     * 但是如果集合元素是基础类型或者不可变类型，老集合某个元素的修改，也不会影响到新集合
     */
    @Test
    public void collectionCloneTest() {

        ArrayList<String> list = new ArrayList<String>(2);
        list.add("hello");
        list.add("world");
        ArrayList<String> newList = (ArrayList) list.clone();
        list.set(1, "新的world");
        /**
         * 未改变，还是原来的值
         */
        System.out.println(newList.get(1));

        ArrayList<MemberVariable> objList = new ArrayList<MemberVariable>(2);
        MemberVariable memberVariable01 = new MemberVariable();
        memberVariable01.setVariableName("包装类型数组01");
        MemberVariable memberVariable02 = new MemberVariable();
        memberVariable02.setVariableName("包装类型数组02");
        objList.add(memberVariable01);
        objList.add(memberVariable02);
        ArrayList<MemberVariable> newObjList = (ArrayList) objList.clone();
        memberVariable01.setVariableName("改变后的包装类型数组01");
        /**
         * 改变了，说明是浅拷贝
         */
        System.out.println(newObjList.get(0).getVariableName());
    }

    /**
     * map的clone也是浅拷贝
     * 但是如果map元素是基础类型或者不可变类型，老map某个元素的修改，也不会影响到新map
     */
    @Test
    public void mapCopyTest() {
        HashMap<String, String> mapData = new HashMap<String, String>(2);
        mapData.put("hello", "hello对应的value");
        mapData.put("world", "world对应的value");
        HashMap<String, String> newMapData = (HashMap) mapData.clone();
        mapData.put("hello", "改变后的hello对应的value");
        System.out.println(newMapData.get("hello"));

        HashMap<String, MemberVariable> objMapData = new HashMap<String, MemberVariable>(2);
        MemberVariable memberVariable01 = new MemberVariable();
        memberVariable01.setVariableName("成员变量01的名字");
        objMapData.put("hello", memberVariable01);
        MemberVariable memberVariable02 = new MemberVariable();
        memberVariable02.setVariableName("成员变量02的名字");
        objMapData.put("world", memberVariable02);
        HashMap<String, MemberVariable> newObjMapData = (HashMap) objMapData.clone();
        memberVariable01.setVariableName("改变后的成员变量01的名字");
        objMapData.put("hello", memberVariable01);
        System.out.println(newObjMapData.get("hello").getVariableName());


    }


}
