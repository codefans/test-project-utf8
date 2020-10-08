package com.codefans.reusablecode.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author: codefans
 * @date: 2019-08-06 15:04
 */
public class JsonUtilsTest {

    @Test
    public void jsonStrToObj() {

        String fileName = "json.txt";
        InputStream is = FileUtils.class.getResourceAsStream(fileName);
        String jsonStr = FileUtils.fileToStr(is);
        System.out.println("jsonStr=" + jsonStr);

        JSONObject jsonObject = JsonUtils.getJsonObj(jsonStr);
        JSONArray jsonArray = (JSONArray) jsonObject.get("content");

        int size = jsonArray.size();
        System.out.println("size=" + size);

        JSONObject jsonObj = null;
        for(int i = 0; i < size; i ++) {
            jsonObj = jsonArray.getJSONObject(i);
            System.out.println("id=" + get(jsonObj,"id") + ", noid=" + get(jsonObj, "noid") + ", name=" + get(jsonObj, "name") + ", votenum=" + get(jsonObj, "votenum") + ", giftcount=" + get(jsonObject, "giftcount") + ", status=" + get(jsonObj, "status") + ", lastvotetime=" + get(jsonObj, "lastvotetime"));
        }

    }

    @Test
    public void jsonFileArrToObj() throws FileNotFoundException {

        String[] filePathArr = new String[]{
            "/Users/codefans/Downloads/Charles-Sessions/Page 1.txt",
            "/Users/codefans/Downloads/Charles-Sessions/Page 2.txt",
            "/Users/codefans/Downloads/Charles-Sessions/Page 3.txt",
            "/Users/codefans/Downloads/Charles-Sessions/Page 4.txt",
            "/Users/codefans/Downloads/Charles-Sessions/Page 5.txt",
            "/Users/codefans/Downloads/Charles-Sessions/Page 6.txt",
            "/Users/codefans/Downloads/Charles-Sessions/Page 7.txt",
        };
        int totalSize = 0;
        for(String filePath : filePathArr) {
            totalSize += this.printFile(filePath);
        }
        System.out.println("totalSize=" + totalSize);

    }

    public int printFile(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        String fileName = file.getName();
        InputStream is = new FileInputStream(file);
        String jsonStr = FileUtils.fileToStr(is);
//        System.out.println("jsonStr=" + jsonStr);

        JSONObject jsonObject = JsonUtils.getJsonObj(jsonStr);
        JSONArray jsonArray = (JSONArray) jsonObject.get("content");

        int size = jsonArray.size();
//        System.out.println("size=" + size);

        JSONObject jsonObj = null;
        String id = "";
        for(int i = 0; i < size; i ++) {
            jsonObj = jsonArray.getJSONObject(i);
            id = String.valueOf(get(jsonObj, "id"));
            System.out.println("fileName=" + fileName + ", id=" + id + ", noid=" + get(jsonObj, "noid") + ", name=" + get(jsonObj, "name") + ", votenum=" + get(jsonObj, "votenum") + ", giftcount=" + get(jsonObj, "giftcount") + ", status=" + get(jsonObj, "status") + ", lastvotetime=" + get(jsonObj, "lastvotetime"));

        }
        return size;
    }

    public Object get(JSONObject jsonObject, String key) {
        return jsonObject.get(key);
    }

}
