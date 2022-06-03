package com.hjy.service;

import com.hjy.pojo.OdsData;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.FileNotFoundException;
import java.sql.SQLException;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hjy
 * @since 2022-04-13
 */
public interface IOdsDataService extends IService<OdsData> {

    void truncate();

    void upgradeAnalyze() throws FileNotFoundException, SQLException;

}
