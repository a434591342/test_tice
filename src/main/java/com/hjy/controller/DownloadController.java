package com.hjy.controller;


import com.hjy.pojo.RespBean;
import com.hjy.service.IDownloadService;
import com.hjy.service.INoticeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hjy
 * @since 2022-04-13
 */
@RestController
@RequestMapping("/download")
public class DownloadController {
    @Autowired
    private IDownloadService downloadService;

    @ApiOperation(value = "获取最近五个service")
    @GetMapping("/getServiceList")
    public RespBean getServiceList(){
        return downloadService.getServiceList();
    }
    @ApiOperation(value = "获取最近五个service")
    @GetMapping("/getAllList")
    public RespBean getAllList(){
        return downloadService.getAllList();
    }
    @ApiOperation(value = "查询对应download详细内容")
    @GetMapping("/getDownload")
    public RespBean getDownload(@RequestParam Integer id){
        return downloadService.selectById(id);
    }

}
