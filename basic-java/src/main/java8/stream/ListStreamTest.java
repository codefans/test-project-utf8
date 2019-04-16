package stream;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: Codefans
 * @date: 2019-04-05 14:26:39
 */
public class ListStreamTest {

    public static void main(String[] args) {
        ListStreamTest listStreamTest = new ListStreamTest();
        listStreamTest.test();
    }

    public void test() {

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
