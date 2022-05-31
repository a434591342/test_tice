package com.hjy.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author hjy
 * @since 2022-04-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("test_score")
@ApiModel(value="TestScore对象", description="")
public class TestScore implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "test_score_id", type = IdType.AUTO)
    private Integer testScoreId;

    @TableField("student_id")
    private Integer studentId;

    private Float height;

    private Float weight;

    @TableField("hw_score")
    private Integer hwScore;

    @TableField("hw_rank")
    private String hwRank;

    @TableField("vitual_capacity")
    private Integer vitualCapacity;

    @TableField("vc_score")
    private Integer vcScore;

    @TableField("vc_rank")
    private String vcRank;

    @TableField("s_50m")
    private Float s50m;

    @TableField("s_50m_score")
    private Integer s50mScore;

    @TableField("s_50m_rank")
    private String s50mRank;

    @TableField("long_jump")
    private Integer longJump;

    @TableField("lj_score")
    private Integer ljScore;

    @TableField("lj_rank")
    private String ljRank;

    @TableField("sit_and_reach")
    private Integer sitAndReach;

    @TableField("sar_score")
    private Integer sarScore;

    @TableField("sar_rank")
    private String sarRank;

    @TableField("s_800m")
    private String s800m;

    @TableField("s_800m_score")
    private Integer s800mScore;

    @TableField("s_800m_rank")
    private String s800mRank;

    @TableField("s_1000m")
    private String s1000m;

    @TableField("s_1000m_score")
    private Integer s1000mScore;

    @TableField("s_1000m_rank")
    private String s1000mRank;

    @TableField("sit_up")
    private Integer sitUp;

    @TableField("su_score")
    private Integer suScore;

    @TableField("su_rank")
    private String suRank;

    @TableField("pull_up")
    private Integer pullUp;

    @TableField("pu_score")
    private Integer puScore;

    @TableField("pu_rank")
    private String puRank;

    @TableField("standard_score")
    private Float standardScore;

    @TableField("add_score")
    private Float addScore;

    @TableField("total_score")
    private Float totalScore;

    @TableField("total_rank")
    private String totalRank;

    private String grade;

    private LocalDate date;

    private Integer gender;


}
