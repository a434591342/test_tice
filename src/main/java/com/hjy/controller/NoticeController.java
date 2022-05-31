package com.hjy.controller;


import com.hjy.pojo.RespBean;
import com.hjy.service.INoticeService;
import com.sun.xml.internal.bind.v2.TODO;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hjy
 * @since 2022-04-13
 */
@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private INoticeService noticeService;

    @ApiOperation(value = "获取最近五个notice")
    @GetMapping("/getNoticeList")
    public RespBean getNoticeList(){
        return noticeService.getNoticeList();
    }
    @ApiOperation(value = "查询对应notice详细内容")
    @GetMapping("/getNotice")
    public RespBean getOneDetail(@RequestParam Integer id){
        return noticeService.selectById(id);
    }
    //todo 未作分页
    @ApiOperation(value = "查询所有notice")
    @GetMapping("/getAllNotice")
    public RespBean getAllNotice(){
        return noticeService.getAllNotice();
    }
}
