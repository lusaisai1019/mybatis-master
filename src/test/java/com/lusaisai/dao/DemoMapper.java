package com.lusaisai.dao;

import com.lusaisai.po.ProjInfo;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface DemoMapper {


   List<ProjInfo>  selectAll(@Param("projId")String projId, @Param("sectionName")String sectionName);

}
