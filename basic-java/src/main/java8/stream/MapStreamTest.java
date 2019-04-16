package stream;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: Codefans
 * @date: 2019-04-16 14:10:52
 */
public class MapStreamTest {

    public static void main(String[] args) {
        MapStreamTest mapStreamTest = new MapStreamTest();
        mapStreamTest.test();
    }

    public void test() {

        List<String> valList = new ArrayList<String>();
        valList.add("111");
        valList.add("222");
        valList.add("333");

        List<String> valList2 = new ArrayList<String>();
        valList2.add("aaa");
        valList2.add("bbb");
        valList2.add("ccc");

        List<String> valList3 = new ArrayList<String>();
        valList3.add("---");
        valList3.add("===");
        valList3.add("+++");

        Map<String, List<String>> map = new HashMap<String, List<String>>();
        map.put("111", valList);
        map.put("222", valList2);
        map.put("333", valList3);

        map = map.entrySet().stream().filter((e)->{
            String key = e.getKey();
            if(Integer.parseInt(key)>=222) {
                return true;
            }
            return false;
        }).collect(Collectors.toMap((e)->{
            return e.getKey();
        },(e)->{
            List<String> dataList = e.getValue();
            dataList.remove(0);
            return dataList;
        }));

        System.out.println(JSON.toJSON(map));

    }




}
