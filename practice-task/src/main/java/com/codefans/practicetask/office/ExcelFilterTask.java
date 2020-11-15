package com.codefans.practicetask.office;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: codefans
 * @Date: 2020-11-14 23:07
 */

public class ExcelFilterTask {

    public static void main(String[] args) {
        ExcelFilterTask excelFilterTask = new ExcelFilterTask();
        excelFilterTask.execute();
    }


    public void execute() {

        try {

            String outExcelPath = "D:\\excel\\整体库存_供应链-output.xlsx";
            String sheetName = "";

            String inExcelPath = "D:\\excel\\整体库存_供应链.xlsx";

            long startTime = System.currentTimeMillis();
            Workbook workbook = this.getWorkbook(inExcelPath);
            System.out.println("读取excel总耗时为=" + (System.currentTimeMillis() - startTime)/1000 + "s");
            Sheet dataInSheet = workbook.getSheetAt(0);
            sheetName = dataInSheet.getSheetName();


            Iterator<Row> iterator = dataInSheet.iterator();

            int lineIndex = 0;

            List<List<String>> dataList = new ArrayList<>();
            List<String> columnList;

            while (iterator.hasNext()) {

                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();

                columnList = new ArrayList<>();

                while (cellIterator.hasNext()) {

                    Cell currentCell = cellIterator.next();

                    //getCellTypeEnum shown as deprecated for version 3.15
                    //getCellTypeEnum ill be renamed to getCellType starting from version 4.0
                    if (currentCell.getCellTypeEnum() == CellType.STRING) {
//                        System.out.print(currentCell.getStringCellValue() + "--");
                        columnList.add(currentCell.getStringCellValue());
                    } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
//                        System.out.print(currentCell.getNumericCellValue() + "--");
                        columnList.add(String.valueOf(currentCell.getNumericCellValue()));
                    } else {
                        columnList.add("");
                    }

                }

                System.out.println("lineIndex=" + lineIndex ++ + ", columnCount=" + columnList.size());
                dataList.add(columnList);
                System.out.println();


            }

            workbook.close();

            System.out.println("总行数为:" + lineIndex);

            System.out.println("过滤前记录数=" + dataList.size());
            this.filter(dataList);
            System.out.println("过滤后记录数=" + dataList.size());

            startTime = System.currentTimeMillis();
            this.write(outExcelPath, sheetName, dataList);
            System.out.println("excel导出总耗时=" + (System.currentTimeMillis() - startTime)/1000 + "s");


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public Workbook getWorkbook(String excelFilePath) throws IOException {
        FileInputStream excelFile = new FileInputStream(new File(excelFilePath));
        Workbook workbook = new XSSFWorkbook(excelFile);
        return workbook;
    }

    /**
     *    0	    1	 2	   3	 4	   5	   6	   7	   8	 9	  10
     * 门店编码 大区  小区	门店名称	类型	物料编码	物料名称	厂家编码	物料品牌	大类	 中类
     *
     * 11	  12	    13	       14	      15	16	  17	  18	   19	      20
     * 小类	库存数量	工单占用数量	采购申请号	收货类型	状态	发货数量	收货数量	待收货数量	创建日期
     *
     * 21	       22	23	  24	   25	   26	 27	     28	       29
     * 库存类型	数据来源	SN	成本价	库存成本	入库时间	库龄	门店入库时间	门店库龄
     *
     *
     * @param dataList
     */
    private void filter(List<List<String>> dataList) {
        LocalDateTime startTime = LocalDateTime.now();

        Iterator<List<String>> iter = dataList.iterator();
        List<String> columnList;
        String value;
        int lineIndex = 0;

        while(iter.hasNext()) {
            columnList = iter.next();
            /**
             * 前3行是标题, 不做过滤
             */
            if(lineIndex++ <= 2) {
                continue;
            }

            /**
             * 数据来源勾选BOMS
             */
            value = columnList.get(22);
            if(!"BOMS".equals(value.trim())) {
                iter.remove();
                continue;
            }
            /**
             * 门店名称筛选苹果字样
             */
            value = columnList.get(3);
            if(!value.contains("苹果")) {
                iter.remove();
                continue;
            }
            /**
             * 大区去掉总部管理
             */
            value = columnList.get(1);
            if("总部管理".equals(value.trim())) {
                iter.remove();
                continue;
            }

            /**
             * 第二步
             * 类型筛选：寄售、良品库、前置良品库、前置寄售库
             */
            value = columnList.get(4);
            if("寄售".equals(value.trim()) || "良品库".equals(value.trim())
                    || "前置良品库".equals(value.trim()) || "前置寄售库".equals(value.trim())) {
//                System.out.println("除了这四个,其他都过滤掉.");
            } else {
                iter.remove();
                continue;
            }

            /**
             * 第三步
             * 厂家编码去掉带"-"横杆的
             */
            value = columnList.get(7);
            if(value.contains("-")) {
                iter.remove();
                continue;
            }

            /**
             * 第四步
             * 中类勾选：保护类、电源类、其他、其他附件、数码配件、外采附件、玩具类、音乐类、音频类、智能设备、整机
             */
            value = columnList.get(10);
            if("保护类".equals(value.trim()) || "电源类".equals(value.trim()) || "其他".equals(value.trim())
                    || "其他附件".equals(value.trim()) || "数码配件".equals(value.trim()) || "外采附件".equals(value.trim())
                    || "玩具类".equals(value.trim()) || "音乐类".equals(value.trim()) || "音频类".equals(value.trim())
                    || "智能设备".equals(value.trim()) || "整机".equals(value.trim())) {
//                System.out.println("除了这些,其他过滤掉.");
            } else {
                iter.remove();
                continue;
            }

            /**
             * 第五步
             * 库存数量去掉空白
             */
            value = columnList.get(12);
            if(value.trim().equals("")) {
                iter.remove();
                continue;
            }

        }
        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("excel过滤总耗时=" + Duration.between(startTime, endTime).getSeconds() + "s");
    }

    public void write(String outExcelPath, String sheetName, List<List<String>> dataList) {

        final LocalDateTime start = LocalDateTime.now();

//        this.writeXSSFWorkbook(outExcelPath, sheetName, dataList);
        this.writeSXSSFWorkbook(outExcelPath, sheetName, dataList);

        final LocalDateTime end = LocalDateTime.now();
        final Duration duration = Duration.between(start, end);
        System.out.println("生成Excel花费时间：" + duration.getSeconds() + "s");

    }


    /**
     * excel数据量达到几万行就有可能报: GC overhead limit exceeded异常
     * @param outExcelPath
     * @param sheetName
     * @param dataList
     */
    public void writeXSSFWorkbook(String outExcelPath, String sheetName, List<List<String>> dataList) {
        XSSFWorkbook outWorkbook = new XSSFWorkbook();
        XSSFSheet dataOutSheet = outWorkbook.createSheet(sheetName);

        List<String> columnList;
        for(int i = 0; i < dataList.size(); i ++) {
            columnList = dataList.get(i);
            Row outRow = dataOutSheet.createRow(i);
            int columnIndex = 0;
            for(int j = 0; j < columnList.size(); j ++) {
                Cell outCell = outRow.createCell(columnIndex++);
                outCell.setCellValue(columnList.get(j));
            }
        }

        writeTo(outWorkbook, outExcelPath);
    }

    public void writeSXSSFWorkbook(String outExcelPath, String sheetName, List<List<String>> dataList) {
        SXSSFWorkbook sxssfWorkbook = getWorkbook(sheetName, dataList);
        this.writeTo(sxssfWorkbook, outExcelPath);
    }

    public void writeTo(Workbook workbook, String outExcelPath) {
        try {
            FileOutputStream outputStream = new FileOutputStream(outExcelPath);
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static SXSSFWorkbook getWorkbook(List<String> title, List<? extends List<?>> data) {
        SXSSFWorkbook workbook = new SXSSFWorkbook();
        // 添加一个sheet
        final Sheet sheet = workbook.createSheet();
        // 构建title
        final Row titleRow = sheet.createRow(0);
        for (int i = 0; i < title.size(); i++) {
            final Cell titleRowCell = titleRow.createCell(i);
            titleRowCell.setCellValue(title.get(i));
        }
        // 填充数据
        for (int i = 0; i < data.size(); i++) {
            final Row row = sheet.createRow(i + 1);
            final List<?> dataRow = data.get(i);
            for (int j = 0; j < dataRow.size(); j++) {
                final Cell cell = row.createCell(j);
                final Object value = dataRow.get(j);
                cell.setCellValue(value == null ? "" : String.valueOf(value));
            }
        }
        return workbook;
    }

    private static SXSSFWorkbook getWorkbook(String sheetName, List<List<String>> data) {
        SXSSFWorkbook workbook = new SXSSFWorkbook();
        // 添加一个sheet
        final Sheet sheet = workbook.createSheet(sheetName);
        for(int i = 0; i < data.size(); i ++) {
            // 构建title
            final Row outRow = sheet.createRow(i);
            final List<String> dataRow = data.get(i);
            for (int j = 0; j < dataRow.size(); j++) {
                final Cell cell = outRow.createCell(j);
                final String value = dataRow.get(j);
                cell.setCellValue(value == null ? "" : value);
            }
        }
        return workbook;
    }


}
