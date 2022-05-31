package com.hjy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hjy.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author hjy
 * @since 2022-04-13
 */
public interface TestScoreMapper extends BaseMapper<TestScore> {


    List<TestScore> selectByID(@Param("id") Integer id);

    Integer selectByIDBestGrade(@Param("id") Integer id);

    Integer selectAveRank(@Param("id") Integer id, @Param("grade") Integer grade);

    Long selectAveScore(@Param("id") Integer id, @Param("grade") Integer grade);

    TestScore selectByTestScoreId(@Param("testScore_id") Integer id);

    List<AllReport> selectAllReportByID(@Param("student_id") Integer id);

    LocalDate getRecentDate();

    Integer selectNumOfSchool(@Param("date") LocalDate date);

    Integer selectBuJiGeOfSchool(@Param("date") LocalDate date);

    Integer getYouXiuNum(@Param("date") LocalDate date);

    rankNum getRankNum(@Param("recentDate") LocalDate recentDate, @Param("gender") Integer gender);

    List<jigelv> getMajorHegeRank(@Param("recentDate") LocalDate recentDate);

    List<passRateOrNotPassRateByItem> getHege(@Param("recentDate") LocalDate recentDate);

    List<passRateOrNotPassRateByItem> getBuHege(@Param("recentDate") LocalDate recentDate);

    List<String> getAllDate();

    List<Double> getHegeByVC();

    List<Double> getHegeBy50m();

    List<Double> getHegeBylj();

    List<Double> getHegeBysar();

    List<Double> gethegeBy800m();

    List<Double> gethegeBy1000m();

    List<Double> gethegeBySitup();

    List<Double> gethegeByPullUp();

    List<scoreByGrade> getScoreByGrade();

    double getHegeByBMI(@Param("recentDate") LocalDate recentDate);

    Integer getbujigeNumByBMI(@Param("recentDate") LocalDate recentDate);

    List<Double> getPassRateByGradeByBMI(@Param("recentDate") LocalDate recentDate);

    List<Integer> getScoreListByBMI(@Param("recentDate") LocalDate recentDate);

    String getBestBmi(@Param("recentDate") LocalDate recentDate);

    Integer getYouXiuNumByBMI(@Param("recentDate") LocalDate recentDate);


    double getHegeByVc(@Param("recentDate") LocalDate recentDate);

    Integer getbujigeNumByVc(@Param("recentDate") LocalDate recentDate);

    List<Double> getPassRateByGradeByVc(@Param("recentDate") LocalDate recentDate);

    List<Integer> getScoreListByVc(@Param("recentDate") LocalDate recentDate);

    String getBestByVc(@Param("recentDate") LocalDate recentDate);

    Integer getYouXiuNumByVc(@Param("recentDate") LocalDate recentDate);
//    50m

    double getHegeBy50(@Param("recentDate") LocalDate recentDate);

    Integer getbujigeNumBy50(@Param("recentDate") LocalDate recentDate);

    List<Double> getPassRateByGradeBy50(@Param("recentDate") LocalDate recentDate);

    List<Integer> getScoreListBy50(@Param("recentDate") LocalDate recentDate);

    String getBestBy50(@Param("recentDate") LocalDate recentDate);

    Integer getYouXiuNumBy50(@Param("recentDate") LocalDate recentDate);
    //   longjump

    double getHegeBylongjump(@Param("recentDate") LocalDate recentDate);

    Integer getbujigeNumBylongjump(@Param("recentDate") LocalDate recentDate);

    List<Double> getPassRateByGradeBylongjump(@Param("recentDate") LocalDate recentDate);

    List<Integer> getScoreListBylongjump(@Param("recentDate") LocalDate recentDate);

    String getBestBylongjump(@Param("recentDate") LocalDate recentDate);

    Integer getYouXiuNumBylongjump(@Param("recentDate") LocalDate recentDate);
    //   sar

    double getHegeBySAR(@Param("recentDate") LocalDate recentDate);

    Integer getbujigeNumBySAR(@Param("recentDate") LocalDate recentDate);

    List<Double> getPassRateByGradeBySAR(@Param("recentDate") LocalDate recentDate);

    List<Integer> getScoreListBySAR(@Param("recentDate") LocalDate recentDate);

    String getBestBySAR(@Param("recentDate") LocalDate recentDate);

    Integer getYouXiuNumBySAR(@Param("recentDate") LocalDate recentDate);

    //   800m

    double getHegeBy800(@Param("recentDate") LocalDate recentDate);

    Integer getbujigeNumBy800(@Param("recentDate") LocalDate recentDate);

    List<Double> getPassRateByGradeBy800(@Param("recentDate") LocalDate recentDate);

    List<Integer> getScoreListBy800(@Param("recentDate") LocalDate recentDate);

    String getBestBy800(@Param("recentDate") LocalDate recentDate);

    Integer getYouXiuNumBy800(@Param("recentDate") LocalDate recentDate);

    //   1000m

    double getHegeBy1000(@Param("recentDate") LocalDate recentDate);

    Integer getbujigeNumBy1000(@Param("recentDate") LocalDate recentDate);

    List<Double> getPassRateByGradeBy1000(@Param("recentDate") LocalDate recentDate);

    List<Integer> getScoreListBy1000(@Param("recentDate") LocalDate recentDate);

    String getBestBy1000(@Param("recentDate") LocalDate recentDate);

    Integer getYouXiuNumBy1000(@Param("recentDate") LocalDate recentDate);

    //   仰卧起坐

    double getHegeBySU(@Param("recentDate") LocalDate recentDate);

    Integer getbujigeNumBySU(@Param("recentDate") LocalDate recentDate);

    List<Double> getPassRateByGradeBySU(@Param("recentDate") LocalDate recentDate);

    List<Integer> getScoreListBySU(@Param("recentDate") LocalDate recentDate);

    String getBestBySU(@Param("recentDate") LocalDate recentDate);

    Integer getYouXiuNumBySU(@Param("recentDate") LocalDate recentDate);

    //   引体向上

    double getHegeByPU(@Param("recentDate") LocalDate recentDate);

    Integer getbujigeNumByPU(@Param("recentDate") LocalDate recentDate);

    List<Double> getPassRateByGradeByPU(@Param("recentDate") LocalDate recentDate);

    List<Integer> getScoreListByPU(@Param("recentDate") LocalDate recentDate);

    String getBestByPU(@Param("recentDate") LocalDate recentDate);

    Integer getYouXiuNumByPU(@Param("recentDate") LocalDate recentDate);

    List<RateByAcademy> getHegeByAcademy(@Param("recentDate") LocalDate recentDate);

    List<RateByAcademy> getYouxiuByAcademy(@Param("recentDate") LocalDate recentDate);

    List<RateByAcademy> getBuHegeByAcademy(@Param("recentDate") LocalDate recentDate);

    List<Double> getHegeChangeByAcademy(@Param("academy") String academy);

    List<Double> getYouxiuChangeByAcademy(@Param("academy") String academy);

    List<Double> getBuhegeChangeByAcademy(@Param("academy") String academy);
}
