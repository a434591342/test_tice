package com.hjy.controller;


import com.hjy.pojo.Download;
import com.hjy.pojo.Notice;
import com.hjy.pojo.RespBean;
import com.hjy.service.IDownloadService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

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
    @ApiOperation(value = "获取所有service")
    @GetMapping("/getAllList")
    public RespBean getAllList(){
        return downloadService.getAllList();
    }
    @ApiOperation(value = "查询对应download详细内容")
    @GetMapping("/getDownload")
    public RespBean getDownload(@RequestParam Integer id){
        return downloadService.selectById(id);
    }

    @ApiOperation(value = "删除download")
    @DeleteMapping("/deleteDownload")
    public RespBean deleteNotice(@RequestBody Integer downloadId){
        System.out.println(downloadId);
        if (downloadService.removeById(downloadId)){
            return RespBean.success("删除成功！");
        }else return RespBean.error("删除失败！");
    }

    @ApiOperation(value = "修改download")
    @PutMapping("/changeDownload")
    public RespBean changeNotice(@RequestBody Download download){
        if (downloadService.updateDownload(download)){
            return RespBean.success("更新成功！");
        }else return RespBean.error("更新失败！");
    }
    @ApiOperation(value ="添加download")
    @PostMapping("/addDownload")
    public RespBean addDownload(@RequestBody Download download){
        LocalDateTime now = LocalDateTime.now();
        download.setTime(now);
        if (downloadService.addDownload(download)){
            return RespBean.success("添加成功！");
        }else return RespBean.error("添加失败！");
    }

}
