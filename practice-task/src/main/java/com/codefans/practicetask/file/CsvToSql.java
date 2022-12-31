package com.codefans.practicetask.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @Author: codefans
 * @Date: 2022-12-31 10:38
 */

public class CsvToSql {
    
    public static void main(String[] args) throws FileNotFoundException {
        CsvToSql csvToSql = new CsvToSql();
        csvToSql.convert();
    }
    
    public void convert() throws FileNotFoundException {
        
//        String csvFilePath = "C:\\Users\\caishengzhi.C0231\\Downloads\\km_catalog.csv";
        String csvFilePath = "C:\\Users\\caishengzhi.C0231\\Downloads\\km_contentpoint.csv";
        String sqlFilePath = "";
        
        File csvFile = new File(csvFilePath);
        System.out.println(csvFile.getParent());
        String csvFileName = csvFile.getName();
        System.out.println("csvFileName=" + csvFileName);
        String tableName = csvFileName.substring(0, csvFileName.indexOf(".csv"));
        System.out.println("tableName=" + tableName);
    
        sqlFilePath = csvFile.getParent() + File.separator + tableName + ".sql";
        System.out.println("sqlFilePath=" + sqlFilePath);
        
        StringBuilder sql = new StringBuilder();
        sql.append("insert into ").append(tableName).append(" (");
        Scanner sc = new Scanner(csvFile);
        int index = 0;
        String line = "";
        while(sc.hasNextLine()) {
            /**
             * 解析列名
             */
            if(index++ == 0) {
                line = sc.nextLine();
                String[] arr = line.split(",");
                for(int i = 0; i < arr.length; i ++) {
                    if(i != 0) {
                        sql.append(",");
                    }
                    sql.append("`").append(arr[i]).append("`");
                    
                }
                sql.append(") values ");
            } else { //解析数据
                line = sc.nextLine();
                sql.append("(");
                String[] arr = line.split(",");
                for(int i = 0; i < arr.length; i ++) {
                    if(i != 0) {
                        sql.append(",");
                    }
                    if("NULL".equals(arr[i])) {
                        sql.append("NULL");
                    } else {
                        sql.append("'").append(trim(arr[i])).append("'");
                    }
                }
                sql.append("),");
            }
        }
        String sqlStr = sql.toString();
        sqlStr = sqlStr.substring(0, sqlStr.length() - 1) + ";";
        System.out.println("sql:");
        System.out.println(sqlStr);
    
        System.out.println(trim("2020-06-10 14:21:03"));
        
    }
    
    private String trim(String str) {
        return str.replaceAll("\"", "");
    }
    
}
