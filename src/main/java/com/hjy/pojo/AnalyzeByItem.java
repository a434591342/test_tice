package com.hjy.pojo;

import lombok.Data;

import java.util.List;

@Data
public class AnalyzeByItem {
    private double passRate;
    private Integer youxiuNum;
    private Integer bujigeNum;
    private String best;
    private List<Integer> scoreList;
    private List<Double> passRateByGrade;
}
