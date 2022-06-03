package com.hjy.controller;

import com.hjy.util.WordUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@RestController
public class wordController {
    @ApiOperation(value = "工单导出", notes = "工单导出")
    @GetMapping(value = "/exportWord")
    public void  exportWord(HttpServletRequest request, HttpServletResponse response)  {
        Map<String, Object> params = new HashMap<>();
   /*//如果word模板地址放在 webapp下采用如下方式获取word模板路径：
   //表示到项目的根目录（webapp）下，要是想到目录下的子文件夹，修改"/"即可
   String path = request.getSession().getServletContext().getRealPath("/");*/

        //word模板地址放在src/main/resources/下，因为配置过静态资源映射，所以采用如下方式获取项目中的word模板地址：
        //String templatePath = "static/template/workOrdersTemplate.docx";//word模板地址

        InputStream is = this.getClass().getClassLoader().getResourceAsStream("templates/word/user.docx");
        // 渲染文本
        params.put("name", "我是");
        params.put("position", "经理");
        params.put("entry_time", "2019-02-02");
        params.put("province", "北京");
        params.put("city","北京");

        String temDir="opt/mimi/"+ File.separator+"file/word/"; ;//生成临时文件存放地址
        // 生成的word格式
        String formatSuffix = ".doc";
        // 拼接后的文件名
        String fileName = "体质健康建议表" + formatSuffix;//文件名  带后缀
        //导出word
        WordUtils.exportWord(is, temDir, fileName, params, request, response);

    }
}

