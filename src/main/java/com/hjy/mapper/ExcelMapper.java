package com.hjy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hjy.pojo.OdsData;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface ExcelMapper extends BaseMapper<OdsData> {
    int insertBatchResident(@Param("odsDataList") List<OdsData> odsDataList);
}
