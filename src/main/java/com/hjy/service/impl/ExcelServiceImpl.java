package com.hjy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hjy.mapper.ExcelMapper;
import com.hjy.pojo.OdsData;
import com.hjy.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ExcelServiceImpl extends ServiceImpl<ExcelMapper, OdsData> implements ExcelService {
    /**
     * 批量添加数据
     *
     * @param residentDtos
     * @return
     */
    @Autowired
    private ExcelMapper excelMapper;
    @Override
    public int insertBatchResident(List<OdsData> residentDtos) {
        return excelMapper.insertBatchResident(residentDtos);
    }
}
