package com.hjy.service;

import com.hjy.pojo.AllReport;
import com.hjy.pojo.Suggestion;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hjy.pojo.report;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hjy
 * @since 2022-04-13
 */
public interface ISuggestionService extends IService<Suggestion> {

    Suggestion selectSugByTestScoreId(Integer id);

    report getSugAndScore(Integer id);

    List<AllReport> getAllReport(Integer id);
}
