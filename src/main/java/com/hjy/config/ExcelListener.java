package com.hjy.config;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.hjy.pojo.OdsData;
import com.hjy.service.ExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ExcelListener extends AnalysisEventListener<OdsData> {


    private static final Logger LOGGER = LoggerFactory.getLogger(ExcelListener.class);
    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 5;
    /**
     * 实现业务逻辑的service
     */
    private final ExcelService excelService;
    /**
     * 保存数据的集合
     */
    List<OdsData> list = new ArrayList<OdsData>();

    /**
     * 如果使用了spring,请使用这个构造方法。每次创建Listener的时候需要把spring管理的类传进来
     *
     * @param
     */
    public ExcelListener(ExcelService excelService) {
        this.excelService = excelService;
    }

    @Override
    public void invoke(OdsData data, AnalysisContext context) {
        list.add(data);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (list.size() >= BATCH_COUNT) {
            saveData();
            // 存储完成清理 list
            list.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        saveData();
        LOGGER.info("所有数据解析完成！");
    }

    /**
     * 加上存储数据库
     */
    private void saveData() {
        //这里才是数据继续数据库存储的重点
        int batchResident = excelService.insertBatchResident(list);
        if (batchResident < 1) {
            LOGGER.info("数据保存异常，未知错误");
        }
    }

}