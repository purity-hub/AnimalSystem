package com.lhy.animalsystem.excel.service.impl;

import com.lhy.animalsystem.excel.entity.HelpAnimal;
import com.lhy.animalsystem.excel.entity.HelpTask;
import com.lhy.animalsystem.excel.entity.VeterinarianHelp;
import com.lhy.animalsystem.excel.mapper.ExcelMapper;
import com.lhy.animalsystem.excel.service.ExcelService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class ExcelServiceImpl implements ExcelService {
    @Autowired
    private ExcelMapper excelMapper;

    @Override
    public List<HelpAnimal> showAll() {
        return excelMapper.selectAll();
    }

    @Override
    public List<HelpAnimal> showAllByPage(int page, int limit) {
        return excelMapper.selectAllByPage(page, limit);
    }

    @Override
    public void download() {

    }

    @Override
    public List<VeterinarianHelp> selectVeterinarian() {
        List<VeterinarianHelp> veterinarianHelps = excelMapper.selectVeterinarian();
        for(VeterinarianHelp veterinarianHelp : veterinarianHelps){
            int id = veterinarianHelp.getId();
            int count = excelMapper.selectCount(id);
            int count1 = excelMapper.selectCount1(id);
            int count2 = excelMapper.selectCount2(id);
            veterinarianHelp.setCount(count);
            veterinarianHelp.setCount1(count1);
            veterinarianHelp.setCount2(count2);
        }
        return veterinarianHelps;
    }

    @Override
    public List<VeterinarianHelp> selectVeterinarianByPage(int page, int limit) {
        List<VeterinarianHelp> veterinarianHelps = excelMapper.selectVeterinarianByPage(page, limit);
        for(VeterinarianHelp veterinarianHelp : veterinarianHelps){
            int id = veterinarianHelp.getId();
            int count = excelMapper.selectCount(id);
            int count1 = excelMapper.selectCount1(id);
            int count2 = excelMapper.selectCount2(id);
            veterinarianHelp.setCount(count);
            veterinarianHelp.setCount1(count1);
            veterinarianHelp.setCount2(count2);
        }
        return veterinarianHelps;
    }

    @Override
    public List<HelpTask> selectHelpTask() {
        return excelMapper.selectHelpTask();
    }

    @Override
    public List<HelpTask> selectHelpTaskByPage(int page, int limit) {
        return excelMapper.selectHelpTaskByPage(page, limit);
    }

    @Override
    public void download1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //当前时间
        //System.out.println(val);
        long begin = System.currentTimeMillis();
        //创建一个工作簿
        Workbook workbook = new HSSFWorkbook();
        //创建表
        Sheet sheet = workbook.createSheet();
        //写入数据
        List<HelpAnimal> helpAnimals = showAll();
        //设置表头
        Row row1 = sheet.createRow(0);
        //设置表头固定
        sheet.createFreezePane(0, 1);
        Cell cell1 = row1.createCell(0);
        cell1.setCellValue("动物名称");
        cell1 = row1.createCell(1);
        cell1.setCellValue("动物类别");
        cell1 = row1.createCell(2);
        cell1.setCellValue("救治类型");
        cell1 = row1.createCell(3);
        cell1.setCellValue("救治医生");
        cell1 = row1.createCell(4);
        cell1.setCellValue("救治时间");
        cell1 = row1.createCell(5);
        cell1.setCellValue("救治结果");
        cell1 = row1.createCell(6);
        cell1.setCellValue("救治去向");
        //设置表格内容
        for (int i = 0; i < helpAnimals.size(); i++) {
            Row row = sheet.createRow(i + 1);
            Cell cell = row.createCell(0);
            cell.setCellValue(helpAnimals.get(i).getName());
            cell = row.createCell(1);
            cell.setCellValue(helpAnimals.get(i).getType());
            cell = row.createCell(2);
            cell.setCellValue(helpAnimals.get(i).getHelptype());
            cell = row.createCell(3);
            cell.setCellValue(helpAnimals.get(i).getVeterinarian());
            cell = row.createCell(4);
            cell.setCellValue(helpAnimals.get(i).getTime());
            cell = row.createCell(5);
            cell.setCellValue(helpAnimals.get(i).getResult());
            cell = row.createCell(6);
            cell.setCellValue(helpAnimals.get(i).getForword());
        }
        FileOutputStream fileOutputStream = new FileOutputStream("message.xls");
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        long end = System.currentTimeMillis();
        //System.out.println("时间为：" + (double) (end - begin) / 1000);//2.262s
        //设置文件路径
        File file = new File("message.xls");
        String fileName = "动物救治统计";
        //response设置中文
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/force-download");// 设置强制下载不打开
        response.addHeader("Content-Disposition", "attachment;fileName=" + toUtf8String(fileName, request)+".xls");//设置文件名
        byte[] buffer = new byte[1024];
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        try {
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            OutputStream os = response.getOutputStream();
            int i = bis.read(buffer);
            while (i != -1) {
                //向客户端发送数据
                os.write(buffer, 0, i);
                i = bis.read(buffer);
            }
            //System.out.println("download success");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void download2(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    public void download3(HttpServletRequest request, HttpServletResponse response) {

    }

    public static String toUtf8String(String fileName, HttpServletRequest request) throws Exception {
        final String userAgent = request.getHeader("USER-AGENT");
        String finalFileName = null;
        if (StringUtils.contains(userAgent, "MSIE")|| StringUtils.contains(userAgent, "Trident")) {// IE浏览器（旧版/新版）
            finalFileName = URLEncoder.encode(fileName, StandardCharsets.UTF_8);
        } else if (StringUtils.contains(userAgent, "Mozilla")) {// google,火狐浏览器
            finalFileName = new String(fileName.getBytes(), "ISO8859-1");
        } else {
            finalFileName = URLEncoder.encode(fileName, StandardCharsets.UTF_8);// 其他浏览器
        }
        return finalFileName;
    }
}
