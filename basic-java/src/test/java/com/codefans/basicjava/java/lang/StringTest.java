package com.codefans.basicjava.java.lang;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: codefans
 * @date: 2018-05-09 17:45
 */
public class StringTest {

    @Test
    public void strReplacement() {
        String sql = "select * from tableX where id=? and name=?";
        List<String> values = new ArrayList<String>();
        values.add("1001");
        values.add("zhangsan");
        for(String name:values) {
            sql = sql.replaceFirst("\\?", name);
        }
        System.out.println(sql);
    }

}
