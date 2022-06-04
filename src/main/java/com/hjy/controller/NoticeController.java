package com.hjy.controller;


import com.hjy.pojo.Notice;
import com.hjy.pojo.RespBean;
import com.hjy.service.INoticeService;
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

    @ApiOperation(value = "删除notice")
    @DeleteMapping ("/deleteNotice")
    public RespBean deleteNotice(@RequestBody Integer noticeId){
        System.out.println(noticeId);
        if (noticeService.removeById(noticeId)){
            return RespBean.success("删除成功！");
        }else return RespBean.error("删除失败！");
    }

    @ApiOperation(value = "修改notice")
    @PutMapping("/changeNotice")
    public RespBean changeNotice(@RequestBody Notice notice){
        if (noticeService.updateNotice(notice)){
            return RespBean.success("更新成功！");
        }else return RespBean.error("更新失败！");
    }
    @ApiOperation(value ="添加notice")
    @PostMapping("/addNotice")
    public RespBean addNotice(@RequestBody Notice notice){
        LocalDateTime now = LocalDateTime.now();
        notice.setNoticeDate(now);
        if (noticeService.addNotice(notice)){
            return RespBean.success("添加成功！");
        }else return RespBean.error("添加失败！");
    }
}
