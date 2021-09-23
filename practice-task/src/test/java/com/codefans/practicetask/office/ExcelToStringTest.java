/**
 * Copyright (C), 2015-2021, 京东
 * FileName: ExcelToStringTest
 * Author:   caishengzhi
 * Date:     2021/9/23 15:28
 * Description: 读取excel内容拼装成字符串
 */
package com.codefans.practicetask.office;


import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * 读取excel内容拼装成字符串
 *
 * @author: codefans
 * @Date: 2021/09/23 15:28
 * @since: 1.0.0
 */
public class ExcelToStringTest extends BaseExcel {

    @Test
    public void excel2str() throws IOException {

        String inExcelPath = "D:\\caishengzhi\\Downloads\\会员开站城市-映射.xlsx";

        long startTime = System.currentTimeMillis();
        Workbook workbook = getWorkbook(inExcelPath);
        System.out.println("读取excel总耗时为=" + (System.currentTimeMillis() - startTime)/1000 + "s");
        Sheet dataInSheet = workbook.getSheetAt(0);

        Iterator<Row> iterator = dataInSheet.iterator();

        int lineIndex = 0;

        NumberFormat numberFormat = NumberFormat.getNumberInstance();

        StringBuilder sb = new StringBuilder();
        StringBuilder nameSb = new StringBuilder();

        while (iterator.hasNext()) {

            Row currentRow = iterator.next();

            if(lineIndex < 1) {
                lineIndex++;
                continue;
            }

            Iterator<Cell> cellIterator = currentRow.iterator();

            int columnIndex = 0;
            String provinceId = "";
            String provinceName = "";
            String cityId = "";
            String cityName = "";
            Cell cell;
            while (cellIterator.hasNext()) {
                cell = cellIterator.next();
                if(columnIndex == 2) {
                    cell.setCellType(CellType.STRING);
                    provinceId = cell.getStringCellValue();
                    columnIndex++;
                } else if(columnIndex == 4) {
                    cell.setCellType(CellType.STRING);
                    cityId = cell.getStringCellValue();
                    columnIndex++;
                } else if(columnIndex == 1) {
                    provinceName = cell.getStringCellValue();
                    columnIndex++;
                } else if(columnIndex == 3) {
                    cityName = cell.getStringCellValue();
                    columnIndex++;
                } else {
                    columnIndex++;
                    continue;
                }
            }

            if(lineIndex == 1) {
                sb.append(provinceId).append("-").append(cityId);
                nameSb.append(provinceName).append("-").append(cityName);
            } else {
                sb.append(",").append(provinceId).append("-").append(cityId);
                nameSb.append(",").append(provinceName).append("-").append(cityName);
            }

            if(lineIndex > 10000) {
                break;
            }
            lineIndex++;
        }

        System.out.println(nameSb.toString());
        System.out.println(sb.toString());

    }

}