/**
 * Copyright (C), 2015-2021, 京东
 * FileName: BaseExcel
 * Author:   codefans
 * Date:     2021/9/23 15:29
 * Description: excel处理基础类
 */
package com.codefans.practicetask.office;


import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * excel处理基础类
 *
 * @author: codefans
 * @Date: 2021/09/23 15:29
 * @since: 1.0.0
 */
public class BaseExcel {

    public Workbook getWorkbook(String excelFilePath) throws IOException {
        FileInputStream excelFile = new FileInputStream(new File(excelFilePath));
        Workbook workbook = new XSSFWorkbook(excelFile);
        return workbook;
    }

}