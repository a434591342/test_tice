package com.hjy.pojo;

import lombok.Data;

import java.util.List;

@Data
public class RateChangeByAcademy {
    private List<String> dates;
    private List<Double> passRates;
}
