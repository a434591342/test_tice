package com.hjy.service.impl;

import com.hjy.pojo.*;
import com.hjy.mapper.TestScoreMapper;
import com.hjy.service.ITestScoreService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hjy
 * @since 2022-04-13
 */
@Service
public class TestScoreServiceImpl extends ServiceImpl<TestScoreMapper, TestScore> implements ITestScoreService {

    @Autowired
    private TestScoreMapper testScoreMapper;

    @Override
    public RespBean selectById(Integer id) {
        List<TestScore> testScores = testScoreMapper.selectByID(id);
        TestScore testScore = testScores.get(0);
        if (testScore!=null){
            return RespBean.success("查询成功!",testScore);
        }else{
            return RespBean.error("查询失败!");
        }
    }

    @Override
    public RespBean getInformation(Integer id) {

        List<TestScore> testScores = testScoreMapper.selectByID(id);
        TestScore testScore = testScores.get(0);
        List<Integer> result = new ArrayList<>();
        // 最近检测学期
        Integer grade = Integer.parseInt(testScore.getGrade());
        result.add(grade);
        // 历史最好成绩
        Integer bestScore = testScoreMapper.selectByIDBestGrade(id);
        result.add(bestScore);
        // 班级平均成绩
        Integer aveScore = Math.toIntExact(testScoreMapper.selectAveScore(id, grade));
        result.add(aveScore);
        // 班级位次
        Integer aveRank = testScoreMapper.selectAveRank(id,grade);
        result.add(aveRank);
        if (result.size()==0){
            return  RespBean.error("查询失败！");
        }else return RespBean.success("查询成功",result);
    }

    @Override
    public TestScore selectByTestScoreId(Integer id) {
        return testScoreMapper.selectById(id);
    }

    @Override
    public RespBean selectChartById(Integer id) {
        List<TestScore> testScores = testScoreMapper.selectByID(id);
        List<String> list = new ArrayList<>();
        List<Float> scores = new ArrayList<>();
        List<List> res = new ArrayList<>();

        for(int i =testScores.size()-1;i>=0;i--){
            list.add(String.valueOf(testScores.get(i).getDate()));
            scores.add(testScores.get(i).getTotalScore());
        }
        res.add(list);
        res.add(scores);
        if (testScores.size()==0){
            return RespBean.error("查询失败！");
        }else return RespBean.success("查询成功！",res);
    }

    @Override
    public LocalDate getRecentDate() {

        return testScoreMapper.getRecentDate();
    }

    @Override
    public Integer selectNumOfSchool(LocalDate date) {

       return testScoreMapper.selectNumOfSchool(date);
    }

    @Override
    public Integer selectBuJiGeOfSchool(LocalDate date) {
        return testScoreMapper.selectBuJiGeOfSchool(date);
    }

    @Override
    public Integer getYouXiuNum(LocalDate date) {
        return testScoreMapper.getYouXiuNum(date);
    }

    @Override
    public List<Integer> getRankNum(LocalDate recentDate,Integer gender) {
        rankNum rankNum = testScoreMapper.getRankNum(recentDate, gender);
        System.out.println(rankNum);
        List<Integer> res = new ArrayList<>();
        res.add(rankNum.getYouxiu());
        res.add(rankNum.getLianghao());
        res.add(rankNum.getJige());
        res.add(rankNum.getBujige());
        return res;
    }

    @Override
    public List<jigelv> getMajorHegeRank(LocalDate recentDate) {
        return testScoreMapper.getMajorHegeRank(recentDate);
    }

    @Override
    public List<passRateOrNotPassRateByItem> getHege(LocalDate recentDate) {
        return testScoreMapper.getHege(recentDate);
    }

    @Override
    public List<passRateOrNotPassRateByItem> getBuHege(LocalDate recentDate) {
        return testScoreMapper.getBuHege(recentDate);
    }

    @Override
    public List<String> getAllDate() {

        return testScoreMapper.getAllDate();
    }

    @Override
    public List<Double> getHegeByVC(Integer sex) {

        return testScoreMapper.getHegeByVC(sex);
    }

    @Override
    public List<Double> getHegeBy50m(Integer sex) {
        return testScoreMapper.getHegeBy50m(sex);
    }

    @Override
    public List<Double> getHegeBylj(Integer sex) {

        return testScoreMapper.getHegeBylj(sex);
    }

    @Override
    public List<Double> getHegeBysar(Integer sex) {
        return testScoreMapper.getHegeBysar(sex);
    }

    @Override
    public List<Double> gethegeBy800m() {
        return testScoreMapper.gethegeBy800m();
    }

    @Override
    public List<Double> gethegeBy1000m() {
        return testScoreMapper.gethegeBy1000m();
    }

    @Override
    public List<Double> gethegeBySitup() {
        return testScoreMapper.gethegeBySitup();
    }

    @Override
    public List<Double> gethegeByPullUp() {
        return testScoreMapper.gethegeByPullUp();
    }

    @Override
    public List<scoreByGrade> getScoreByGrade(LocalDate recentDate) {
        return testScoreMapper.getScoreByGrade(recentDate);
    }

    @Override
    public AnalyzeByItem getAnalyzeByItem(String item) {
        AnalyzeByItem analyzeByItem = new AnalyzeByItem();
        if (item.equals("bmi")){
            LocalDate recentDate = testScoreMapper.getRecentDate();
            analyzeByItem.setPassRate(testScoreMapper.getHegeByBMI(recentDate));
            analyzeByItem.setYouxiuNum(testScoreMapper.getYouXiuNumByBMI(recentDate));
            analyzeByItem.setBujigeNum(testScoreMapper.getbujigeNumByBMI(recentDate));
            analyzeByItem.setPassRateByGrade(testScoreMapper.getPassRateByGradeByBMI(recentDate));
            analyzeByItem.setScoreList(testScoreMapper.getScoreListByBMI(recentDate));
            analyzeByItem.setBest(testScoreMapper.getBestBmi(recentDate));
        }else if (item.equals("肺活量")){
            LocalDate recentDate = testScoreMapper.getRecentDate();
            analyzeByItem.setPassRate(testScoreMapper.getHegeByVc(recentDate));
            analyzeByItem.setYouxiuNum(testScoreMapper.getYouXiuNumByVc(recentDate));
            analyzeByItem.setBujigeNum(testScoreMapper.getbujigeNumByVc(recentDate));
            analyzeByItem.setPassRateByGrade(testScoreMapper.getPassRateByGradeByVc(recentDate));
            analyzeByItem.setScoreList(testScoreMapper.getScoreListByVc(recentDate));
            analyzeByItem.setBest(testScoreMapper.getBestByVc(recentDate));
        }else if(item.equals("50米")){
            LocalDate recentDate = testScoreMapper.getRecentDate();
            analyzeByItem.setPassRate(testScoreMapper.getHegeBy50(recentDate));
            analyzeByItem.setYouxiuNum(testScoreMapper.getYouXiuNumBy50(recentDate));
            analyzeByItem.setBujigeNum(testScoreMapper.getbujigeNumBy50(recentDate));
            analyzeByItem.setPassRateByGrade(testScoreMapper.getPassRateByGradeBy50(recentDate));
            analyzeByItem.setScoreList(testScoreMapper.getScoreListBy50(recentDate));
            analyzeByItem.setBest(testScoreMapper.getBestBy50(recentDate));
        }else if(item.equals("跳远")){
            LocalDate recentDate = testScoreMapper.getRecentDate();
            analyzeByItem.setPassRate(testScoreMapper.getHegeBylongjump(recentDate));
            analyzeByItem.setYouxiuNum(testScoreMapper.getYouXiuNumBylongjump(recentDate));
            analyzeByItem.setBujigeNum(testScoreMapper.getbujigeNumBylongjump(recentDate));
            analyzeByItem.setPassRateByGrade(testScoreMapper.getPassRateByGradeBylongjump(recentDate));
            analyzeByItem.setScoreList(testScoreMapper.getScoreListBylongjump(recentDate));
            analyzeByItem.setBest(testScoreMapper.getBestBylongjump(recentDate));
        }else if (item.equals("坐位体前屈")){
            LocalDate recentDate = testScoreMapper.getRecentDate();
            analyzeByItem.setPassRate(testScoreMapper.getHegeBySAR(recentDate));
            analyzeByItem.setYouxiuNum(testScoreMapper.getYouXiuNumBySAR(recentDate));
            analyzeByItem.setBujigeNum(testScoreMapper.getbujigeNumBySAR(recentDate));
            analyzeByItem.setPassRateByGrade(testScoreMapper.getPassRateByGradeBySAR(recentDate));
            analyzeByItem.setScoreList(testScoreMapper.getScoreListBySAR(recentDate));
            analyzeByItem.setBest(testScoreMapper.getBestBySAR(recentDate));
        }else if(item.equals("800米")){
            LocalDate recentDate = testScoreMapper.getRecentDate();
            analyzeByItem.setPassRate(testScoreMapper.getHegeBy800(recentDate));
            analyzeByItem.setYouxiuNum(testScoreMapper.getYouXiuNumBy800(recentDate));
            analyzeByItem.setBujigeNum(testScoreMapper.getbujigeNumBy800(recentDate));
            analyzeByItem.setPassRateByGrade(testScoreMapper.getPassRateByGradeBy800(recentDate));
            analyzeByItem.setScoreList(testScoreMapper.getScoreListBy800(recentDate));
            analyzeByItem.setBest(testScoreMapper.getBestBy800(recentDate));
        }else if (item.equals("1000米")){
            LocalDate recentDate = testScoreMapper.getRecentDate();
            analyzeByItem.setPassRate(testScoreMapper.getHegeBy1000(recentDate));
            analyzeByItem.setYouxiuNum(testScoreMapper.getYouXiuNumBy1000(recentDate));
            analyzeByItem.setBujigeNum(testScoreMapper.getbujigeNumBy1000(recentDate));
            analyzeByItem.setPassRateByGrade(testScoreMapper.getPassRateByGradeBy1000(recentDate));
            analyzeByItem.setScoreList(testScoreMapper.getScoreListBy1000(recentDate));
            analyzeByItem.setBest(testScoreMapper.getBestBy1000(recentDate));
        }else if (item.equals("仰卧起坐")){
            LocalDate recentDate = testScoreMapper.getRecentDate();
            analyzeByItem.setPassRate(testScoreMapper.getHegeBySU(recentDate));
            analyzeByItem.setYouxiuNum(testScoreMapper.getYouXiuNumBySU(recentDate));
            analyzeByItem.setBujigeNum(testScoreMapper.getbujigeNumBySU(recentDate));
            analyzeByItem.setPassRateByGrade(testScoreMapper.getPassRateByGradeBySU(recentDate));
            analyzeByItem.setScoreList(testScoreMapper.getScoreListBySU(recentDate));
            analyzeByItem.setBest(testScoreMapper.getBestBySU(recentDate));
        }else{
            LocalDate recentDate = testScoreMapper.getRecentDate();
            analyzeByItem.setPassRate(testScoreMapper.getHegeByPU(recentDate));
            analyzeByItem.setYouxiuNum(testScoreMapper.getYouXiuNumByPU(recentDate));
            analyzeByItem.setBujigeNum(testScoreMapper.getbujigeNumByPU(recentDate));
            analyzeByItem.setPassRateByGrade(testScoreMapper.getPassRateByGradeByPU(recentDate));
            analyzeByItem.setScoreList(testScoreMapper.getScoreListByPU(recentDate));
            analyzeByItem.setBest(testScoreMapper.getBestByPU(recentDate));
        }
        return analyzeByItem;
    }

    @Override
    public List<RateByAcademy> getHegeByAcademy(LocalDate recentDate) {

        return testScoreMapper.getHegeByAcademy(recentDate);
    }

    @Override
    public List<RateByAcademy> getYouxiuByAcademy(LocalDate recentDate) {
        return testScoreMapper.getYouxiuByAcademy(recentDate);
    }

    @Override
    public List<RateByAcademy> getBuHegeByAcademy(LocalDate recentDate) {
        return testScoreMapper.getBuHegeByAcademy(recentDate);
    }

    @Override
    public RateChangeByAcademy getHegeChangeByAcademy(String academy) {
        List<String> allDate = testScoreMapper.getAllDate();
        List<Double> changeRate = testScoreMapper.getHegeChangeByAcademy(academy);
        RateChangeByAcademy rateChangeByAcademy = new RateChangeByAcademy();
        rateChangeByAcademy.setDates(allDate);
        rateChangeByAcademy.setPassRates(changeRate);
        return rateChangeByAcademy;
    }

    @Override
    public RateChangeByAcademy getYouxiuChangeByAcademy(String academy) {
        List<String> allDate = testScoreMapper.getAllDate();
        List<Double> changeRate = testScoreMapper.getYouxiuChangeByAcademy(academy);
        RateChangeByAcademy rateChangeByAcademy = new RateChangeByAcademy();
        rateChangeByAcademy.setDates(allDate);
        rateChangeByAcademy.setPassRates(changeRate);
        return rateChangeByAcademy;
    }
    @Override
    public RateChangeByAcademy getBuhegeChangeByAcademy(String academy) {
        List<String> allDate = testScoreMapper.getAllDate();
        List<Double> changeRate = testScoreMapper.getBuhegeChangeByAcademy(academy);
        RateChangeByAcademy rateChangeByAcademy = new RateChangeByAcademy();
        rateChangeByAcademy.setDates(allDate);
        rateChangeByAcademy.setPassRates(changeRate);
        return rateChangeByAcademy;
    }

    @Override
    public RespBean selectAllById(Integer id) {
        List<TestScore> testScores = testScoreMapper.selectByID(id);
        if (testScores.size()!=0){
            return RespBean.success("查询成功!",testScores);
        }else{
            return RespBean.error("查询失败!");
        }

    }
}
