package com.hjy.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="报告对象", description="")
public class report implements Serializable {
//    基本信息
    private String name;
    private Integer school_num;
    private String academy_name;
    private String major_name;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private LocalDate reportDate;
    private String sex;
    private String note;
//    项目成绩
    private Integer hwScore;
    private String hwRank;

    private Integer vitualCapacity;;
    private String vcRank;

    private Float s50m;
    private String s50mRank;

    private Integer longJump;
    private String ljRank;

    private Integer sitAndReach;
    private String sarRank;

    private String longRun;
    private String longRunRank;

    private Integer sitUpOrPullUp;
    private String sitUpOrPullUpRank;
//    建议
    private List<String> suggestion;
    private String class_suggestion;
}
