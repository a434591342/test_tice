package com.hjy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjy.pojo.OdsData;

import java.util.List;

public interface ExcelService extends IService<OdsData> {
    /**
     * 批量添加数据
     */
    int insertBatchResident(List<OdsData> residentDtos);
}
