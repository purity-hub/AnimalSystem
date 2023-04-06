package com.lhy.animalsystem.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;

/**
 * HSSF方式导出：HSSF方式，最多只支持65536条数据导出，超过这个条数会报错！
 * 就是.xls模式
 */
public class ExcelWrite2003Test {
    private static  String PATH = "D://";//自己输出的路径

    public static void main(String[] args) throws Exception {
        //时间
        long begin = System.currentTimeMillis();

        //创建一个工作簿
        Workbook workbook = new HSSFWorkbook();
        //创建表
        Sheet sheet = workbook.createSheet();
        //写入数据
        for (int rowNumber = 0; rowNumber < 65536; rowNumber++) {
            //创建行
            Row row = sheet.createRow(rowNumber);
            for (int cellNumber = 0; cellNumber < 10; cellNumber++) {
                //创建列
                Cell cell = row.createCell(cellNumber);
                cell.setCellValue(cellNumber);
            }
        }
        System.out.println("结束！");
        FileOutputStream fileOutputStream = new FileOutputStream(PATH + "用户信息表-XLS.xls");
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        long end = System.currentTimeMillis();
        System.out.println("时间为："+(double) (end - begin) / 1000);//2.262s
    }
}
