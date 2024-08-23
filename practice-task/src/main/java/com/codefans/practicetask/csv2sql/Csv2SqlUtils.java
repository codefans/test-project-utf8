package com.codefans.practicetask.csv2sql;

import java.io.*;
import java.util.Scanner;

/**
 * @Author: codefans
 * @Date: 2024-08-08 15:34
 */

public class Csv2SqlUtils {

    public static void main(String[] args) throws IOException {
        Csv2SqlUtils csv2SqlUtils = new Csv2SqlUtils();
        csv2SqlUtils.convert();
    }

    public void convert() throws IOException {

        String csvFilePath = "C:\\Users\\caishengzhi\\Desktop\\";
        String csvFileName = "企业名单-20240821.txt";

        File csvFile = new File(csvFilePath + csvFileName);
        File csvFile_out = new File(csvFilePath + "enter_out.txt");
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(csvFile_out), "UTF-8");
        BufferedWriter bw = new BufferedWriter(osw);
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(csvFile), "UTF-8"));
        String line = null;
        StringBuilder sb = new StringBuilder();
        sb.append("insert into eciticcfc.enterprise_email(logo,name,enterprise_type,email_suffix,status,display_order, start_time, create_by, create_time, enterprise_code) values ");
        bw.write(sb.toString());
        bw.newLine();
        int displayOrder = 1;
        int codeIndex = 1;
        boolean firstLine = true;

        while((line = br.readLine()) != null) {
//            line = sc.nextLine();
            if(firstLine) {
                firstLine = false;
                continue;
            }
            String[] arr = line.split(",");
            sb = new StringBuilder();
            if(arr.length == 3) {
                sb.append("('").append(arr[0]).append("','").append(new String(arr[1].getBytes("UTF-8"), "UTF-8")).append("','").append(arr[2]).append("','").append("null").append("','").append("0").append("',").append(displayOrder++).append(",").append("now()").append(",'").append("admin").append("',").append("now()").append(",'").append(this.appendLeft(codeIndex++)).append("'),");
            } else {
                sb.append("('").append(arr[0]).append("','").append(new String(arr[1].getBytes("UTF-8"), "UTF-8")).append("','").append(arr[2]).append("','").append(arr[3]).append("','").append("0").append("',").append(displayOrder++).append(",").append("now()").append(",'").append("admin").append("',").append("now()").append(",'").append(this.appendLeft(codeIndex++)).append("'),");
            }
            bw.write(sb.toString());
            bw.newLine();
        }
        br.close();
        bw.flush();
        bw.close();
        System.out.println(sb.toString());

    }

    /**
     *
     * @param code
     * @return
     */
    private String appendLeft(int code) {
        String codeStr = String.valueOf(code);
        int len = codeStr.length();
        StringBuffer sb = new StringBuffer();
        sb.append(codeStr);
        for(int i = 0; i < 8- len - 1; i ++) {
            sb.insert(0, "0");
        }
        return "E" + sb.toString();
    }

}
