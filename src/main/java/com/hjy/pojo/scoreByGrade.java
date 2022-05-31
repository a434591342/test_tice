package com.hjy.pojo;

import lombok.Data;

import java.util.List;

@Data
public class scoreByGrade {
    private List<Integer> youxiu;
    private List<Integer> lianghao;
    private List<Integer> jige;
    private List<Integer> bujige;
}
