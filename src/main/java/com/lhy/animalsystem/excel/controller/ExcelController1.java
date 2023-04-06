package com.lhy.animalsystem.excel.controller;

import com.lhy.animalsystem.excel.entity.HelpAnimal;
import com.lhy.animalsystem.excel.entity.HelpTask;
import com.lhy.animalsystem.excel.entity.VeterinarianHelp;
import com.lhy.animalsystem.excel.service.ExcelService;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/excel")
public class ExcelController1 {

    @Autowired
    private ExcelService excelService;

    @RequestMapping("/info/showall")
    public Map<String, Object> index(@RequestParam(defaultValue = "1") int page,
                                     @RequestParam(defaultValue = "10") int limit,
                                     @RequestParam(defaultValue = "") String type) {
        //默认为第一个选项
        if(type.equals("兽医救治任务统计")){
            List<VeterinarianHelp> veterinarianHelps = excelService.selectVeterinarian();
            List<VeterinarianHelp> veterinarianHelps1 = excelService.selectVeterinarianByPage((page - 1) * limit, limit);
            HashMap<String, Object> map = new HashMap<>();
            map.put("code", 0);
            map.put("msg", "请求信息");
            map.put("count", veterinarianHelps.size());
            map.put("data", veterinarianHelps1);
            return map;
        }else if(type.equals("动物救治统计") || type.equals("")){
            //默认为第一个选项
            List<HelpAnimal> helpAnimals = excelService.showAll();
            List<HelpAnimal> helpAnimals1 = excelService.showAllByPage((page - 1) * limit, limit);
            HashMap<String, Object> map = new HashMap<>();
            map.put("code", 0);
            map.put("msg", "请求信息");
            map.put("count", helpAnimals.size());
            map.put("data", helpAnimals1);
            return map;
        }else if(type.equals("救治任务信息统计")){
            List<HelpTask> helpTasks = excelService.selectHelpTask();
            List<HelpTask> helpTasks1 = excelService.selectHelpTaskByPage((page - 1) * limit, limit);
            HashMap<String, Object> map = new HashMap<>();
            map.put("code", 0);
            map.put("msg", "请求信息");
            map.put("count", helpTasks.size());
            map.put("data", helpTasks1);
            return map;
        }else{
            HashMap<String, Object> map = new HashMap<>();
            map.put("code", 0);
            map.put("msg", "请求信息");
            map.put("count", 0);
            map.put("data", null);
            return map;
        }
    }

    @RequestMapping("/helpanimal/download")
    public String download(@RequestParam("val") String val,
                           HttpServletRequest request,
                           HttpServletResponse response) throws Exception {
        //当前时间
        //System.out.println(val);
        //long begin = System.currentTimeMillis();
        //创建一个工作簿
        Workbook workbook = new HSSFWorkbook();
        //创建表
        Sheet sheet = workbook.createSheet();
        //写入数据
        if(Objects.equals(val, "动物救治统计")){
            List<HelpAnimal> helpAnimals = excelService.showAll();
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
        }else if(Objects.equals(val, "兽医救治任务统计")) {
            List<VeterinarianHelp> veterinarianHelps = excelService.selectVeterinarian();
            //设置表头
            Row row1 = sheet.createRow(0);
            //设置表头固定
            sheet.createFreezePane(0, 1);
            Cell cell1 = row1.createCell(0);
            cell1.setCellValue("兽医姓名");
            cell1 = row1.createCell(1);
            cell1.setCellValue("兽医资质");
            cell1 = row1.createCell(2);
            cell1.setCellValue("兽医专业");
            cell1 = row1.createCell(3);
            cell1.setCellValue("兽医指派救治任务数");
            cell1 = row1.createCell(4);
            cell1.setCellValue("待救治任务数");
            cell1 = row1.createCell(5);
            cell1.setCellValue("已救治任务数");
            //设置表格内容
            for (int i = 0; i < veterinarianHelps.size(); i++) {
                Row row = sheet.createRow(i + 1);
                Cell cell = row.createCell(0);
                cell.setCellValue(veterinarianHelps.get(i).getName());
                cell = row.createCell(1);
                cell.setCellValue(veterinarianHelps.get(i).getDegee());
                cell = row.createCell(2);
                cell.setCellValue(veterinarianHelps.get(i).getProfession());
                cell = row.createCell(3);
                cell.setCellValue(veterinarianHelps.get(i).getCount());
                cell = row.createCell(4);
                cell.setCellValue(veterinarianHelps.get(i).getCount1());
                cell = row.createCell(5);
                cell.setCellValue(veterinarianHelps.get(i).getCount2());
            }
        }else if(Objects.equals(val, "救治任务信息统计")) {
            List<HelpTask> helpTasks = excelService.selectHelpTask();
            //设置表头
            Row row1 = sheet.createRow(0);
            //设置表头固定
            sheet.createFreezePane(0, 1);
            Cell cell1 = row1.createCell(0);
            cell1.setCellValue("申请时间");
            cell1 = row1.createCell(1);
            cell1.setCellValue("救助动物");
            cell1 = row1.createCell(2);
            cell1.setCellValue("救助类型");
            cell1 = row1.createCell(3);
            cell1.setCellValue("流转状态");
            //设置表格内容
            for (int i = 0; i < helpTasks.size(); i++) {
                Row row = sheet.createRow(i + 1);
                Cell cell = row.createCell(0);
                cell.setCellValue(helpTasks.get(i).getDate());
                cell = row.createCell(1);
                cell.setCellValue(helpTasks.get(i).getAnimal());
                cell = row.createCell(2);
                cell.setCellValue(helpTasks.get(i).getType());
                cell = row.createCell(3);
                cell.setCellValue(helpTasks.get(i).getState());
            }
        }
        FileOutputStream fileOutputStream = new FileOutputStream("message.xls");
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        //long end = System.currentTimeMillis();
        //System.out.println("时间为：" + (double) (end - begin) / 1000);//2.262s
        //设置文件路径
        File file = new File("message.xls");
        String fileName = val;
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
        return null;
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
