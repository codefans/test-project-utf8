package com.codefans.practicetask.office;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author: codefans
 * @date: 2020-02-07 22:19
 */
public class ExcelUtils {

    public static List<List<String>> xssfRead(String filePath) {

        File excelFile = new File(filePath);
        if(!excelFile.exists()) {
            throw new IllegalArgumentException("文件:[" + filePath + "]不存在。");
        }

        List<List<String>> ansList = new ArrayList<List<String>>();
        List<String> line = null;

        try{


            //读取xlsx文件
            XSSFWorkbook xssfWorkbook = null;
            //寻找目录读取文件
            InputStream is = new FileInputStream(excelFile);
            xssfWorkbook = new XSSFWorkbook(is);

            int numberOfSheets = xssfWorkbook.getNumberOfSheets();
            int columnCount = 3;

            //遍历xlsx中的sheet
            for (int numSheet = 0; numSheet < numberOfSheets; numSheet++) {
                XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
                if (xssfSheet == null) {
                    continue;
                }

                int lastRowNum = xssfSheet.getLastRowNum();
                // 对于每个sheet，读取其中的每一行
                for (int rowNum = 0; rowNum <= lastRowNum; rowNum++) {
                    XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                    if (xssfRow == null) continue;
                    ArrayList<String> curarr=new ArrayList<String>();
                    String cellTypeName = "";
                    String cellValue = "";
                    CellType cellType = null;
                    line = new ArrayList<String>();

                    for(int columnNum = 0 ; columnNum<columnCount ; columnNum++){
                        XSSFCell cell = xssfRow.getCell(columnNum);
                        //                        System.out.println(cell);

                        if(cell != null) {
                            cellType = cell.getCellTypeEnum();
                            if (cellType != null) {
                                cellTypeName = cellType.name();
                            }
                        }

                        if("STRING".equalsIgnoreCase(cellTypeName)) {

                            if(rowNum == 0) {
                                cellValue = cell.getStringCellValue();
                            }

//                            System.out.println("STRING:" + cell.getStringCellValue());
                        } else if ("NUMERIC".equalsIgnoreCase(cellTypeName)) {
                            Double d = cell.getNumericCellValue();
                            DecimalFormat df = new DecimalFormat("#.##");
                            cellValue = df.format(d);

                        } else if ("FORMULA".equalsIgnoreCase(cellTypeName)) {
                            cellValue = cell.getCellFormula();
                            //System.out.println("FORMULA:" + cell.getCellFormula());
//                            System.out.println("FORMULA:" + cell.getCTCell());
                        } else {
                            System.out.println("UNKNOW:" + cell);
                        }
                        line.add(cellValue);
                    }
                    ansList.add(line);

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ansList;
    }

    public void xssfWrite(String excelFilePath, List<String> weightList, Map<String, BigDecimal> weightPriceMap, BigDecimal totalPrice) {

        OutputStream os = null;

//        try {
//
//
//            Workbook wb = new XSSFWorkbook();
//            Sheet sheet = (Sheet) wb.createSheet("答案");
//
//            int dataSize = weightList.size();
//            int rowSize = dataSize + 2;
//
//            Row row = null;
//            Cell cell = null;
//
//            CellStyle style = wb.createCellStyle(); // 样式对象
//            // 设置单元格的背景颜色为淡蓝色
//            style.setFillForegroundColor((short) Color.BLUE.getBlue());
//            // 样式，居中
//            style.setVerticalAlignment(VerticalAlignment.CENTER);// 垂直
//            style.setAlignment(HorizontalAlignment.CENTER);// 水平
//            style.setWrapText(true);// 指定当单元格内容显示不下时自动换行
//
//            row = sheet.createRow(0);
//
//            int columnIndex = 0;
//
//            cell = row.createCell(columnIndex);
//            if(columnIndex == priceColumnIndex) {
//                cell.setCellValue("单价");
//            } else if(columnIndex == weightColumnIndex) {
//                cell.setCellValue("数量");
//            }
//            cell.setCellStyle(style);
//            columnIndex++;
//
//            Cell cell2 = row.createCell(columnIndex);
//            if(columnIndex == priceColumnIndex) {
//                cell2.setCellValue("单价");
//            } else if(columnIndex == weightColumnIndex) {
//                cell2.setCellValue("数量");
//            }
//            cell2.setCellStyle(style);
//            columnIndex++;
//
//            Cell cell3 = row.createCell(columnIndex);
//            cell3.setCellValue("总价");
//            cell3.setCellStyle(style);
//
//            columnIndex = 0;
//            String weight = "";
//            String price = "";
//            BigDecimal totalUnitPrice = new BigDecimal("0");
//
//            int columnCount = 3;
//
//            for(int i = 0; i < dataSize; i ++) {
//
//                row = sheet.createRow(i + 1);
//                weight = weightList.get(i);
//                price = weightPriceMap.get(weight).toString();
//
//                cell = row.createCell(columnIndex);
//                if(columnIndex == priceColumnIndex) {
//                    cell.setCellValue(price);
//                } else if(columnIndex == weightColumnIndex) {
//                    cell.setCellValue(weight);
//                }
//                cell.setCellStyle(style);
//                columnIndex++;
//
//                cell2 = row.createCell(columnIndex);
//                if(columnIndex == priceColumnIndex) {
//                    cell2.setCellValue(price);
//                } else if(columnIndex == weightColumnIndex) {
//                    cell2.setCellValue(weight);
//                }
//                cell2.setCellStyle(style);
//                columnIndex++;
//
//                BigDecimal weightDecimal = new BigDecimal(weight);
//                BigDecimal priceDecimal = new BigDecimal(price);
//                totalUnitPrice = weightDecimal.multiply(priceDecimal).setScale(2, RoundingMode.HALF_EVEN);
//
//                cell3 = row.createCell(columnIndex);
//                cell3.setCellValue(totalUnitPrice.toString());
//                cell3.setCellStyle(style);
//
//                columnIndex = 0;
//
//            }
//
//            row = sheet.createRow(dataSize + 1);
//
//            cell = row.createCell(columnIndex++);
//            cell.setCellValue("");
//            cell.setCellStyle(style);
//
//            cell2 = row.createCell(columnIndex++);
//            cell2.setCellValue("");
//            cell2.setCellStyle(style);
//
//            cell3 = row.createCell(columnIndex++);
//            cell3.setCellValue(totalPrice.setScale(2, RoundingMode.HALF_DOWN).toString());
//            cell3.setCellStyle(style);
//
//
//            File excelFile = new File(excelFilePath);
//            if(!excelFile.exists()) {
//                boolean createSuccess = excelFile.createNewFile();
//                if(createSuccess) {
//                    System.out.println("文件:[" + excelFilePath + "]不存在，已创建成功！");
//                }
//            }
//            os = new FileOutputStream(excelFile);
//            wb.write(os);
//
//            System.out.println("写excel文件结束.");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if(os != null) {
//                    os.flush();
//                    os.close();
//                    os = null;
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }


    }

}
