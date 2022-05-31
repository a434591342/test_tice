package com.hjy.service.impl;

import com.hjy.mapper.*;
import com.hjy.pojo.*;
import com.hjy.service.ISuggestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class SuggestionServiceImpl extends ServiceImpl<SuggestionMapper, Suggestion> implements ISuggestionService {
    @Autowired
    private SuggestionMapper suggestionMapper;
    @Autowired
    private TestScoreMapper testScoreMapper;
    @Autowired
    private StudentInfoMapper studentInfoMapper;
    @Autowired
    private MajorMapper majorMapper;
    @Autowired
    private AcademyMapper academyMapper;
    @Autowired
    private SuggestionClassifyMapper suggestionClassifyMapper;
    @Override
    public Suggestion selectSugByTestScoreId(Integer id) {
        return  suggestionMapper.selectSugByTestScoreId(id);
    }

    @Override
    public report getSugAndScore(Integer id) {

        TestScore testScore = testScoreMapper.selectByTestScoreId(id); //体测成绩
        StudentInfo studentInfo = studentInfoMapper.selectById(testScore.getStudentId());// 基本信息
        Major major = majorMapper.selectById(studentInfo.getMajorId());

        String academyName = academyMapper.selectNameById(major.getAcademyId());
        Suggestion suggestion = suggestionMapper.selectSugByTestScoreId(id);
        report report = new report();
        // 基本信息
        report.setSchool_num(testScore.getStudentId());
        report.setName(studentInfo.getName());
        report.setAcademy_name(academyName);
        report.setMajor_name(major.getMajorName());
        report.setReportDate(testScore.getDate());
        report.setSex(studentInfo.getSex()==1?"男":"女");
        report.setNote(studentInfo.getNote());
        // 体测成绩
        report.setHwScore(testScore.getHwScore());
        report.setHwRank(testScore.getHwRank());
        report.setVitualCapacity(testScore.getVitualCapacity());
        report.setVcRank(testScore.getVcRank());
        report.setS50m(testScore.getS50m());
        report.setS50mRank(testScore.getS50mRank());
        report.setLongJump(testScore.getLongJump());
        report.setLjRank(testScore.getLjRank());
        report.setSitAndReach(testScore.getSitAndReach());
        report.setSarRank(testScore.getSarRank());
        if(studentInfo.getSex()==1){
            report.setLongRun(testScore.getS1000m());
            report.setLongRunRank(testScore.getS1000mRank());
            report.setSitUpOrPullUp(testScore.getPullUp());
            report.setSitUpOrPullUpRank(testScore.getPuRank());
        }else {
            report.setLongRun(testScore.getS800m());
            report.setLongRunRank(testScore.getS800mRank());
            report.setSitUpOrPullUp(testScore.getSitUp());
            report.setSitUpOrPullUpRank(testScore.getSuRank());
        }
        //建议
        List<String> sugList = new ArrayList<>();
        String teacherSug = suggestion.getTeacherSug();
        String[] split = teacherSug.split(",");
        for (String s:split){
            sugList.add(suggestionClassifyMapper.selectSug(Integer.parseInt(s)));
        }
        report.setSuggestion(sugList);
        report.setClass_suggestion(suggestion.getClassSug());
        return report;
    }

    @Override
    public List<AllReport> getAllReport(Integer id) {
        return testScoreMapper.selectAllReportByID(id);
    }
}
