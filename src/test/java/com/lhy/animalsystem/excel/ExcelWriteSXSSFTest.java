package com.lhy.animalsystem.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.FileOutputStream;

public class ExcelWriteSXSSFTest {
    public static String PATH = "/Users/lixin/Desktop/";

    public static void main(String[] args) throws Exception {
        //时间
        long begin = System.currentTimeMillis();

        //创建一个工作簿
        Workbook workbook = new SXSSFWorkbook();

        //创建表
        Sheet sheet = workbook.createSheet();

        //写入数据
        for (int rowNumber = 0; rowNumber < 100000; rowNumber++) {
            Row row = sheet.createRow(rowNumber);
            for (int cellNumber = 0; cellNumber < 10; cellNumber++) {
                Cell cell = row.createCell(cellNumber);
                cell.setCellValue(cellNumber);
            }
        }
        System.out.println("over");

        FileOutputStream fileOutputStream = new FileOutputStream(PATH + "用户信息表-SXSSF.xlsx");
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        long end = System.currentTimeMillis();
        System.out.println((double) (end - begin) / 1000);//6.39s
    }
}
