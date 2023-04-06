package com.lhy.animalsystem.excel.mapper;

import com.lhy.animalsystem.excel.entity.HelpAnimal;
import com.lhy.animalsystem.excel.entity.HelpTask;
import com.lhy.animalsystem.excel.entity.VeterinarianHelp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExcelMapper {

    List<HelpAnimal> selectAll();

    List<HelpAnimal> selectAllByPage(int page, int limit);

    List<VeterinarianHelp> selectVeterinarian();

    int selectCount(int id);//全部数量

    int selectCount1(int id);//待救治数量

    int selectCount2(int id);//已救治数量

    List<VeterinarianHelp> selectVeterinarianByPage(int page, int limit);

    List<HelpTask> selectHelpTask();

    List<HelpTask> selectHelpTaskByPage(int page, int limit);
}
