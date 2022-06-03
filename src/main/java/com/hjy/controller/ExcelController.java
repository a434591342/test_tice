package com.hjy.controller;

import com.alibaba.excel.EasyExcel;
import com.hjy.config.ExcelListener;
import com.hjy.pojo.OdsData;
import com.hjy.pojo.RespBean;
import com.hjy.service.ExcelService;
import com.hjy.service.IOdsDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

@Api(value = "文件上传", tags = "文件上传相关接口")
@RestController
@RequestMapping("/api/excel")
public class ExcelController {
    public static Logger logger = LoggerFactory.getLogger(ExcelController.class);
    @Resource
    private ExcelService excelService;

    @Autowired
    private IOdsDataService odsDataService;

    @PostMapping("/uploadRes")
    public RespBean upload(@RequestParam MultipartFile file) {
        InputStream fileInputStream = null;
        try {
            fileInputStream = file.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
            return RespBean.error("上传文件异常");
        }
        try {
            //先清空ods_data
            odsDataService.truncate();
            //调用EasyExcel.read然后去调用你写的监听器，随后去执行你写的Service
            EasyExcel.read(fileInputStream, OdsData.class, new ExcelListener(excelService)).sheet().doRead();
            return RespBean.success("上传文件成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return RespBean.error("未知错误");
    }
    @ApiOperation(value = "更新系统分析信息")
    @GetMapping("/upgradeAnalyze")
    public RespBean upgradeAnalyze(){

        try {
            odsDataService.upgradeAnalyze();
            return RespBean.success("成功");
        } catch (FileNotFoundException | SQLException e) {
            return RespBean.error(String.valueOf(e));
        }
    }

}