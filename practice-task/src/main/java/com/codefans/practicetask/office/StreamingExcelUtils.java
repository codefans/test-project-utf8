package com.codefans.practicetask.office;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Author: codefans
 * @Date: 2020-11-15 09:58
 *
 * 参考资料：
 *    https://juejin.im/post/6844903858460688391
 *
 */

public class StreamingExcelUtils {

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

    public static void main(String[] args) {
        int col = 10;
        int row = 100_0000;
        final List<String> title = IntStream.rangeClosed(1, col)
                .mapToObj(value -> "第" + value + "列")
                .collect(Collectors.toList());

        final List<List<Double>> data = IntStream.range(0, row)
                .mapToObj(value ->
                        IntStream.range(0, col)
                                .mapToObj(ignore -> Math.random())
                                .collect(Collectors.toList())
                )
                .collect(Collectors.toList());

        final LocalDateTime start = LocalDateTime.now();
        final SXSSFWorkbook workbook = getWorkbook(title, data);
        try (OutputStream outputStream = new FileOutputStream("D:/excel/测试.xlsx")) {
            workbook.write(outputStream);
            // 丢弃在磁盘上备份此工作簿的临时文件
            workbook.dispose();
        } catch (IOException e) {
            e.printStackTrace();
        }
        final LocalDateTime end = LocalDateTime.now();
        final Duration duration = Duration.between(start, end);
        System.out.println("生成Excel花费时间：" + duration);
    }



}
