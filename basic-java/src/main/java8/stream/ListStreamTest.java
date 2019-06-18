package stream;

import com.alibaba.fastjson.JSON;
import org.apache.commons.collections.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: Codefans
 * @date: 2019-04-05 14:26:39
 */
public class ListStreamTest {

    public static void main(String[] args) {
        ListStreamTest listStreamTest = new ListStreamTest();
//        listStreamTest.filterSubList();
        listStreamTest.findOne();
    }

    public void filterSubList() {

        Byte b = 1;
        Byte bb = 1;
        System.out.println(b.equals(bb));

        List<String> list = new ArrayList<String>();
        list.add("111");
        list.add("222");
        list.add("333");
        list.add("444");
        list.add("555");

        List<String> subList = list.stream().filter(
                string -> Integer.parseInt(string) >= 333
        ).map((e)->{
            if(e.equals("444")) {
                return "444_aaa";
            } else {
                return e;
            }
        }).collect(Collectors.toList());

        this.print(list);
        this.print(subList);

        /**
         * list过滤出一个子列表
         */
        List<String> subClsList = list.stream().filter(
                sub -> sub.equals("111") || sub.equals("333")
        ).collect(Collectors.toList());

        System.out.println(subClsList.size());

    }

    public void findOne() {

        List<String> list = new ArrayList<String>();
        list.add("111");
        list.add("222");
        list.add("333");
        list.add("444");
        list.add("555");

        List<String> subList = list.stream().filter(
                string -> Integer.parseInt(string) >= 666
        ).collect(Collectors.toList());
        if(CollectionUtils.isNotEmpty(subList)) {
            System.out.println(subList.get(0));
        }

        /**
         * list中找出符合条件的一条记录
         */
        String str = list.stream().filter(
                string -> Integer.parseInt(string) >= 666
        ).collect(Collectors.joining());
        System.out.println("str=" + str);

        List<SubClass> subClassList = new ArrayList<SubClass>();
        subClassList.add(new SubClass("zhangsan", "123"));
        subClassList.add(new SubClass("lisi", "456"));
        subClassList.add(new SubClass("wangwu", "789"));
        subClassList.add(new SubClass("zhaoliu", "012"));
        subClassList.add(new SubClass("qianqi", "345"));

        /**
         * list过滤出其中的一条,如果没找到就new一个
         */
        SubClass subClass = subClassList.stream().filter(
                sub -> sub.getName().equals("dfdfdf")
        ).findFirst().orElse(new SubClass("dfdfdf", "123"));
        System.out.println(subClass);



    }

    public void print(List<String> list) {
        for(int i = 0; i < list.size(); i ++) {
            if(i == 0) {
                System.out.print(list.get(i));
            } else {
                System.out.print(", " + list.get(i));
            }
        }
        System.out.println();
    }

}

class SubClass {

    public SubClass(String name, String password) {
        this.name = name;
        this.password = password;
    }
    String name;
    String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
