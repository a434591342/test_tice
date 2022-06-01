package com.hjy.controller;


import com.hjy.pojo.*;
import com.hjy.service.ITestScoreService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hjy
 * @since 2022-04-13
 */
@RestController
@RequestMapping("/test-score")
public class TestScoreController {

    @Autowired
    private ITestScoreService testscoreService;


    @ApiOperation(value = "查询最近一次体测成绩")
    @GetMapping("/getLastTestScore")
    public RespBean getLastTestScore(@RequestParam Integer id){
        return testscoreService.selectById(id);
    }


    @ApiOperation(value = "历史最好成绩和班级平均成绩，平均位次和学期")
    @GetMapping("/getBestAndEvr")
    public RespBean getBestAndEvr(@RequestParam Integer id){
        return testscoreService.getInformation(id);
    }

    @ApiOperation(value = "身体素质变化表")
    @GetMapping("/getAllScoreChart")
    public RespBean getAllScore(@RequestParam Integer id){
         return testscoreService.selectChartById(id);
    }

    @PostMapping("/exportDataWord")
    @ResponseBody
    @ApiOperation(value="下载report", httpMethod = "POST",produces="application/json",notes = "导出用户doc")
    public RespBean exportDoc() throws  IOException{
        Configuration configuration = new Configuration();
        configuration.setDefaultEncoding("utf-8");
        configuration.setClassForTemplateLoading(this.getClass(), "/templates/word");
        Template template = configuration.getTemplate("UserInfo.ftl");
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("name","gaolei");
        dataMap.put("id","02201");
        dataMap.put("code","251525v");
        dataMap.put("pwd","root");
        dataMap.put("tel","08583552");
        File outFile = new File("UserInfoTest.doc");
        Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile),"UTF-8"));
        try {
            template.process(dataMap,out);
            out.flush();
            out.close();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        return RespBean.success("成功");
    }

    @ApiOperation(value = "查询最近的全校体测信息")
    @GetMapping("/getRecentAllSchoolScore")
    public RespBean getRecentAllSchoolScore(){
        List<Integer> res = new ArrayList<>();
        LocalDate date = testscoreService.getRecentDate();
        Integer num = testscoreService.selectNumOfSchool(date);
        res.add(num);
        Integer bujigeNum = testscoreService.selectBuJiGeOfSchool(date);
        res.add(bujigeNum);
        Integer youxiuNum = testscoreService.getYouXiuNum(date);
        res.add(youxiuNum);
        if (res.size()==3){
            return RespBean.success("查询成功",res);
        }else return RespBean.error("查询失败");
    }

    @ApiOperation(value = "查询男女的各个分段数量")
    @GetMapping("/getAllRankNum")
    public RespBean getAllRankNum(){
        LocalDate recentDate = testscoreService.getRecentDate();
        List<Integer> boyScore = testscoreService.getRankNum(recentDate,1);//1代表男，2代表女
        List<Integer> girlScore = testscoreService.getRankNum(recentDate,2);
        List<List<Integer>> res = new ArrayList<>();
        res.add(girlScore);
        res.add(boyScore);
        if (res.size()==2){
            return RespBean.success("查询成功",res);
        }else return RespBean.error("查询失败");
    }

    @ApiOperation(value = "当年合格率专业排名")
    @GetMapping("/getMajorHegeRank")
    public RespBean getMajorHegeRank(){
        LocalDate recentDate = testscoreService.getRecentDate();
        List<jigelv> res = testscoreService.getMajorHegeRank(recentDate);
        if (res.size()!=0){
            return RespBean.success("查询成功",res);
        }else return RespBean.error("查询失败");
    }
    @ApiOperation(value = "单项合格情况")
    @GetMapping("/getHege")
    public RespBean getHege(){
        LocalDate recentDate = testscoreService.getRecentDate();
        List<passRateOrNotPassRateByItem> res = testscoreService.getHege(recentDate);
        if (res.size()!=0){
            return RespBean.success("查询成功！",res);
        }else return RespBean.error("查询失败！");
    }
    @ApiOperation(value = "单项不合格情况")
    @GetMapping("/getBuHege")
    public RespBean getBuHege(){
        LocalDate recentDate = testscoreService.getRecentDate();
        List<passRateOrNotPassRateByItem> res = testscoreService.getBuHege(recentDate);
        if (res.size()!=0){
            return RespBean.success("查询成功！",res);
        }else return RespBean.error("查询失败！");
    }

    @ApiOperation(value = "每一项的合格率和趋势")
    @GetMapping("/getHegeByItem")
    public RespBean getHegeByItem(){
        Map res = new HashMap();
        List vc = new ArrayList();
        // 所有年份
        List<String> years = testscoreService.getAllDate();
        //及格率
        List<Double> VCPassRates= testscoreService.getHegeByVC();
        // 每年的及格率
        vc.add(years);
        vc.add(VCPassRates);
        res.put("肺活量",vc);

        List<Double> s50mPassRates = testscoreService.getHegeBy50m();
        List s50 = new ArrayList();
        s50.add(years);
        s50.add(s50mPassRates);
        res.put("50米",s50);

        List<Double> ljPassRates = testscoreService.getHegeBylj();
        List lj = new ArrayList();
        lj.add(years);
        lj.add(ljPassRates);
        res.put("跳远",lj);

        List<Double> sarPassRates = testscoreService.getHegeBysar();
        List sar = new ArrayList();
        sar.add(years);
        sar.add(sarPassRates);
        res.put("坐位体前屈",sar);

        List<Double> s800mPassRates = testscoreService.gethegeBy800m();
        List s800 = new ArrayList();
        s800.add(years);
        s800.add(s800mPassRates);
        res.put("800米",s800);

        List<Double> s1000mPassRates = testscoreService.gethegeBy1000m();
        List s1000 = new ArrayList();
        s800.add(years);
        s800.add(s1000mPassRates);
        res.put("1000米",s1000);

        List<Double> sitUpPassRates = testscoreService.gethegeBySitup();
        List sitUp = new ArrayList();
        sitUp.add(years);
        sitUp.add(sitUpPassRates);
        res.put("仰卧起坐",sitUp);

        List<Double> pullUpPassRates = testscoreService.gethegeByPullUp();
        List pullUp = new ArrayList();
        pullUp.add(years);
        pullUp.add(pullUpPassRates);
        res.put("引体向上",pullUp);

        if (res.size()!=0){
            return RespBean.success("查询成功！",res);
        }else return RespBean.error("查询失败！");

    }

    @ApiOperation(value = "年级的成绩分布")
    @GetMapping("/getScoreByGrade")
    public RespBean getScoreByGrade(){
        List<scoreByGrade> res = testscoreService.getScoreByGrade();
        if (res.size()!=0){
            return RespBean.success("查询成功！",res);
        }else return RespBean.error("查询失败！");
    }
    @ApiOperation(value = "每个项目的分析")///input:bmi,肺活量,50米,跳远,坐位体前屈,800米,1000米,仰卧起坐，引体向上
    @PostMapping("/getAnalyzeByItem")
    public RespBean getAnalyzeByItem(@RequestParam String item){
        AnalyzeByItem analyzeByItem = testscoreService.getAnalyzeByItem(item);
        if (analyzeByItem != null) {
            return RespBean.success("查询成功！",analyzeByItem);
        }else return RespBean.error("查询失败！");
    }
    @ApiOperation(value = "各学院合格率分布情况")
    @GetMapping("/getHegeByAcademy")
    public RespBean getHegeByAcademy(){
        LocalDate recentDate = testscoreService.getRecentDate();
        List<RateByAcademy> hegeByAcademies = testscoreService.getHegeByAcademy(recentDate);
        if (hegeByAcademies.size()!=0){
            return RespBean.success("查询成功！",hegeByAcademies);
        }else  return RespBean.error("查询失败！");
    }
    @ApiOperation(value = "各学院优秀率分布情况")
    @GetMapping("/getYouxiuByAcademy")
    public RespBean getYouxiuByAcademy(){
        LocalDate recentDate = testscoreService.getRecentDate();
        List<RateByAcademy> youxiuByAcademies = testscoreService.getYouxiuByAcademy(recentDate);
        if (youxiuByAcademies.size()!=0){
            return RespBean.success("查询成功！",youxiuByAcademies);
        }else  return RespBean.error("查询失败！");
    }
    @ApiOperation(value = "各学院不合格率分布情况")
    @GetMapping("/getBuHegeByAcademy")
    public RespBean getBuHegeByAcademy(){
        LocalDate recentDate = testscoreService.getRecentDate();
        List<RateByAcademy> buhegeByAcademies = testscoreService.getBuHegeByAcademy(recentDate);
        if (buhegeByAcademies.size()!=0){
            return RespBean.success("查询成功！",buhegeByAcademies);
        }else  return RespBean.error("查询失败！");
    }

    @ApiOperation(value = "各学院合格率趋势变化情况")
    @PostMapping("/getHegeChangeByAcademy")
    public RespBean getHegeChangeByAcademy(@RequestBody String academy){
        RateChangeByAcademy rateChangeByAcademy = testscoreService.getHegeChangeByAcademy(academy);
        if (rateChangeByAcademy!=null){
            return RespBean.success("查询成功！",rateChangeByAcademy);
        }else return RespBean.error("查询失败！");
    }

    @ApiOperation(value = "各学院优秀率趋势变化情况")
    @PostMapping("/getYouxiuChangeByAcademy")
    public RespBean getYouxiuChangeByAcademy(@RequestBody String academy){
        RateChangeByAcademy rateChangeByAcademy = testscoreService.getYouxiuChangeByAcademy(academy);
        if (rateChangeByAcademy!=null){
            return RespBean.success("查询成功！",rateChangeByAcademy);
        }else return RespBean.error("查询失败！");
    }

    @ApiOperation(value = "各学院不合格率趋势变化情况")
    @PostMapping("/getBuhegeChangeByAcademy")
    public RespBean getBuhegeChangeByAcademy(@RequestBody String academy){
        RateChangeByAcademy rateChangeByAcademy = testscoreService.getBuhegeChangeByAcademy(academy);
        if (rateChangeByAcademy!=null){
            return RespBean.success("查询成功！",rateChangeByAcademy);
        }else return RespBean.error("查询失败！");
    }

}
