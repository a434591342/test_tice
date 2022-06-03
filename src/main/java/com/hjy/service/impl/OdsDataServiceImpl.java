package com.hjy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hjy.mapper.OdsDataMapper;
import com.hjy.pojo.OdsData;
import com.hjy.service.IOdsDataService;
import com.hjy.util.executeSql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.sql.SQLException;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hjy
 * @since 2022-04-13
 */
@Service
public class OdsDataServiceImpl extends ServiceImpl<OdsDataMapper, OdsData> implements IOdsDataService {

    @Autowired
    private OdsDataMapper odsDataMapper;
    @Override
    public void truncate() {
        odsDataMapper.truncate();
    }

    @Override
    public void upgradeAnalyze() throws FileNotFoundException, SQLException {
        executeSql executeSql = new executeSql();
        executeSql.run();
    }
}
