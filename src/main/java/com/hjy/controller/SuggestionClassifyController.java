package com.hjy.controller;


import com.hjy.pojo.RespBean;
import com.hjy.pojo.SuggestionClassify;
import com.hjy.service.ISuggestionClassifyService;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("/suggestion-classify")
public class SuggestionClassifyController {

    @Autowired
    private ISuggestionClassifyService suggestionClassifyService;

    @ApiOperation(value = "查询相关建议")
    @GetMapping("/selectSug")
    public RespBean selectSug(){
        List<SuggestionClassify> list = suggestionClassifyService.list();
        if (list.size()!=0){
            return RespBean.success("查询成功！",list);
        }else return RespBean.error("查询失败！");
    }

    @ApiOperation(value = "修改对应建议")
    @PostMapping("/changeSug")
    public RespBean changeSug(@RequestBody SuggestionClassify suggestionClassify){
        if (suggestionClassifyService.changeSug(suggestionClassify)){
            return RespBean.success("查询成功");
        }else return RespBean.error("查询失败！");
    }

}
