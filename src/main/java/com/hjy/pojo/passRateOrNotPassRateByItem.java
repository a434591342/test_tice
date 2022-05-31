package com.hjy.pojo;

import lombok.Data;

@Data
public class passRateOrNotPassRateByItem {
    private String item;
    private float passRateOrNotPassRate;
    private String bestScore;
    private Integer rank_;
}
