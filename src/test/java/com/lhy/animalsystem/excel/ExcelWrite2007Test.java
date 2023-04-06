package com.lhy.animalsystem.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;

/**
 * .xlsx方式
 */
public class ExcelWrite2007Test {
    public static String PATH = "D://";

    public static void main(String[] args) throws Exception {
        //时间
        long begin = System.currentTimeMillis();

        //创建一个工作簿
        Workbook workbook = new XSSFWorkbook();
        //创建表
        Sheet sheet = workbook.createSheet();
        //写入数据
        for (int rowNumber = 0; rowNumber < 65537; rowNumber++) {
            Row row = sheet.createRow(rowNumber);
            for (int cellNumber = 0; cellNumber < 10; cellNumber++) {
                Cell cell = row.createCell(cellNumber);
                cell.setCellValue(cellNumber);
            }
        }
        System.out.println("结束");

        FileOutputStream fileOutputStream = new FileOutputStream(PATH + "用户信息表-XLSX.xlsx");
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        long end = System.currentTimeMillis();
        System.out.println((double) (end - begin) / 1000);//5.003s
    }
}
