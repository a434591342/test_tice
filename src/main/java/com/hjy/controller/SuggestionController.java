package com.hjy.controller;


import com.hjy.pojo.*;
import com.hjy.service.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
@RequestMapping("/suggestion")
public class SuggestionController {
    @Autowired
    private ISuggestionService suggestionService;

    @ApiOperation(value = "查询报告详情")
    @GetMapping("/getSugAndScore")
    public RespBean getSugAndScore(@RequestParam Integer id){
        report res = suggestionService.getSugAndScore(id);
        if (res!=null){
            return RespBean.success("查询成功",res);
        }else return RespBean.error("查询失败!");
    }

    @ApiOperation(value = "查询所有报告")
    @GetMapping("getAllReport")
    public RespBean getAllReport(@RequestParam Integer id){
        List<AllReport> res = suggestionService.getAllReport(id);
        if (res.size()!=0){
            return RespBean.success("查询成功！",res);
        }else return RespBean.error("查询失败！");
    }

}
