package com.lhy.animalsystem.excel.service;

import com.lhy.animalsystem.excel.entity.HelpAnimal;
import com.lhy.animalsystem.excel.entity.HelpTask;
import com.lhy.animalsystem.excel.entity.VeterinarianHelp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface ExcelService {
    List<HelpAnimal> showAll();

    List<HelpAnimal> showAllByPage(int page, int limit);

    void download();

    List<VeterinarianHelp> selectVeterinarian();

    List<VeterinarianHelp> selectVeterinarianByPage(int page, int limit);

    List<HelpTask> selectHelpTask();

    List<HelpTask> selectHelpTaskByPage(int page, int limit);

    void download1(HttpServletRequest request, HttpServletResponse response) throws Exception;

    void download2(HttpServletRequest request, HttpServletResponse response);

    void download3(HttpServletRequest request, HttpServletResponse response);
}
