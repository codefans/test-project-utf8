package com.codefans.opensource.ognl;

import ognl.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: ShengzhiCai
 * @date: 2020-02-10 12:03
 */
public class OgnlUtilTest {

    @Test
    public void testGetValue() throws OgnlException {

        InnerBean innerBean = new InnerBean();
        innerBean.setName("zhangsan");
        innerBean.setAge(23);
        List<String> list = new ArrayList<String>();
        list.add("hello");
        list.add("world");
        Map<String, String> map = new HashMap<String,String>();
        map.put("111", "111");
        map.put("222", "222");
        map.put("333", "333");
        innerBean.setList(list);
        innerBean.setMap(map);

        InnerClassB innerClassB = new InnerClassB();
        innerClassB.setAddr("后屯路32号院");
        List<String> innerList = new ArrayList<String>();
        innerList.add("张三");
        innerList.add("李四");
        Map<String, String> innerMap = new HashMap<String,String>();
        innerMap.put("444", "444");
        innerMap.put("555", "555");
        innerMap.put("666", "666");
        innerClassB.setList(innerList);
        innerClassB.setMap(innerMap);

        innerBean.setInnerClassB(innerClassB);

//        System.out.println(OgnlUtil.getValue("name", innerBean));


        // 构建一个OgnlContext对象
        // 扩展，支持传入class类型的参数
        OgnlContext context = (OgnlContext) Ognl.createDefaultContext(this,
                new DefaultMemberAccess(true), new DefaultClassResolver(), new DefaultTypeConverter());
        context.setRoot(innerBean);

        // 测试case
        Object nameObj = Ognl.getValue(Ognl.parseExpression("name"), context, context.getRoot());
        System.out.println("nameObj:" + nameObj);

        Object ageObj = Ognl.getValue(Ognl.parseExpression("age"), context, context.getRoot());
        System.out.println("ageObj:" + ageObj);

        Object list0Obj = Ognl.getValue(Ognl.parseExpression("list[0]"), context, context.getRoot());
        System.out.println("list0Obj:" + list0Obj);

        Object map111Obj = Ognl.getValue(Ognl.parseExpression("map['111']"), context, context.getRoot());
        System.out.println("map111Obj:" + map111Obj);

        Object innerClassBObj = Ognl.getValue(Ognl.parseExpression("innerClassB"), context, context.getRoot());
        System.out.println("innerClassBObj:" + innerClassBObj);

        Object innerClassBAddrObj = Ognl.getValue(Ognl.parseExpression("innerClassB.addr"), context, context.getRoot());
        System.out.println("innerClassBAddrObj:" + innerClassBAddrObj);

        Object innerClassBList1Obj = Ognl.getValue(Ognl.parseExpression("innerClassB.list[1]"), context, context.getRoot());
        System.out.println("innerClassBList1Obj:" + innerClassBList1Obj);

        Object innerClassBMap555Obj = Ognl.getValue(Ognl.parseExpression("innerClassB.map['555']"), context, context.getRoot());
        System.out.println("innerClassBMap555Obj:" + innerClassBMap555Obj);

        Ognl.setValue("innerClassB.addr", context, innerBean, "海淀区后屯路32号院2号楼4单元201室");
        innerClassBAddrObj = Ognl.getValue(Ognl.parseExpression("innerClassB.addr"), context, context.getRoot());
        System.out.println("innerClassBAddrObj:" + innerClassBAddrObj);

//        context.put("obj", innerBean);
//
//        // 测试case
////        Object nameObj = Ognl.getValue(Ognl.parseExpression("#obj.name"), context, context.getRoot());
////        System.out.println("nameObj:" + nameObj);
//
//        ageObj = Ognl.getValue(Ognl.parseExpression("#obj.age"), context, context.getRoot());
//        System.out.println("ageObj:" + ageObj);
//
//        list0Obj = Ognl.getValue(Ognl.parseExpression("#obj.list[0]"), context, context.getRoot());
//        System.out.println("list0Obj:" + list0Obj);
//
//        map111Obj = Ognl.getValue(Ognl.parseExpression("#obj.map['111']"), context, context.getRoot());
//        System.out.println("map111Obj:" + map111Obj);

    }

    class InnerBean {

        private String name;

        private int age;

        private List<String> list;

        private Map<String, String> map;

        private InnerClassB innerClassB;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public List<String> getList() {
            return list;
        }

        public void setList(List<String> list) {
            this.list = list;
        }

        public Map<String, String> getMap() {
            return map;
        }

        public void setMap(Map<String, String> map) {
            this.map = map;
        }

        public InnerClassB getInnerClassB() {
            return innerClassB;
        }

        public void setInnerClassB(InnerClassB innerClassB) {
            this.innerClassB = innerClassB;
        }
    }

    class InnerClassB {

        private String addr;

        private List<String> list;

        private Map<String, String> map;

        public String getAddr() {
            return addr;
        }

        public void setAddr(String addr) {
            this.addr = addr;
        }

        public List<String> getList() {
            return list;
        }

        public void setList(List<String> list) {
            this.list = list;
        }

        public Map<String, String> getMap() {
            return map;
        }

        public void setMap(Map<String, String> map) {
            this.map = map;
        }
    }

}
