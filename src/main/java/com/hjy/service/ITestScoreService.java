package com.hjy.service;

import com.hjy.pojo.*;
import com.baomidou.mybatisplus.extension.service.IService;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hjy
 * @since 2022-04-13
 */
public interface ITestScoreService extends IService<TestScore> {
    RespBean selectById(Integer id);

    RespBean getInformation(Integer id);

    TestScore selectByTestScoreId(Integer id);

    RespBean selectChartById(Integer id);

    LocalDate getRecentDate();

    Integer selectNumOfSchool(LocalDate date);

    Integer selectBuJiGeOfSchool(LocalDate date);

    Integer getYouXiuNum(LocalDate date);

    List<Integer> getRankNum(LocalDate recentDate,Integer gender);

    List<jigelv> getMajorHegeRank(LocalDate recentDate);

    List<passRateOrNotPassRateByItem> getHege(LocalDate recentDate);

    List<passRateOrNotPassRateByItem> getBuHege(LocalDate recentDate);

    List<String> getAllDate();

    List<Double> getHegeByVC(Integer sex);

    List<Double> getHegeBy50m(Integer sex);

    List<Double> getHegeBylj(Integer sex);

    List<Double> getHegeBysar(Integer sex);

    List<Double> gethegeBy800m();

    List<Double> gethegeBy1000m();

    List<Double> gethegeBySitup();

    List<Double> gethegeByPullUp();

    List<scoreByGrade> getScoreByGrade(LocalDate recentDate);

    AnalyzeByItem getAnalyzeByItem(String item);

    List<RateByAcademy> getHegeByAcademy(LocalDate recentDate);

    List<RateByAcademy> getYouxiuByAcademy(LocalDate recentDate);

    List<RateByAcademy> getBuHegeByAcademy(LocalDate recentDate);

    RateChangeByAcademy getHegeChangeByAcademy(String academy);

    RateChangeByAcademy getYouxiuChangeByAcademy(String academy);

    RateChangeByAcademy getBuhegeChangeByAcademy(String academy);
}
