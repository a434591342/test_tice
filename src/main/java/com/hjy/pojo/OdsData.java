package com.hjy.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

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
@TableName("ods_data")
@ApiModel(value="OdsData对象", description="")
public class OdsData implements Serializable {

//    private static final long serialVersionUID = 1L;
//
//    @TableId(value = "id", type = IdType.AUTO)
//    private Integer id;
    @ExcelProperty(value = "年级编号")
    private Integer grade;

    @TableField("class_num")
    @ExcelProperty(index = 1, value = "班级编号")
    private Integer classNum;

    @TableField("class_name")
    @ExcelProperty(index = 2, value = "班级名称")
    private String className;

    @TableField("student_num")
    @ExcelProperty(index = 3, value = "学籍号")
    private Integer studentNum;

    @TableField("nation_id")
    @ExcelProperty(index = 4, value = "民族代码")
    private Integer nationId;

    @ExcelProperty(index = 5, value = "姓名")
    private String name;

    @ExcelProperty(index = 6, value = "性别")
    private Integer sex;

    @ExcelProperty(index = 7, value = "出生日期")
    private String birthday;

    @ExcelProperty(index = 8, value = "家庭住址")
    private String address;

    @ExcelProperty(index = 9, value = "身高")
    private Integer height;

    @ExcelProperty(index = 10, value = "体重")
    private Float weight;

    @TableField("hw_score")
    @ExcelProperty(index = 11, value = "体重评分")
    private Integer hwScore;

    @TableField("hw_rank")
    @ExcelProperty(index = 12, value = "体重等级")
    private String hwRank;

    @TableField("vitual_capacity")
    @ExcelProperty(index = 13, value = "肺活量")
    private Integer vitualCapacity;

    @TableField("vc_score")
    @ExcelProperty(index = 14, value = "肺活量评分")
    private Integer vcScore;

    @TableField("vc_rank")
    @ExcelProperty(index = 15, value = "肺活量等级")
    private String vcRank;

    @TableField("s_50m")
    @ExcelProperty(index = 16, value = "50米跑")
    private Float s50m;

    @TableField("s_50m_score")
    @ExcelProperty(index = 17, value = "50米跑评分")
    private Integer s50mScore;

    @TableField("s_50m_rank")
    @ExcelProperty(index = 18, value = "50米跑等级")
    private String s50mRank;

    @TableField("long_jump")
    @ExcelProperty(index = 19, value = "立定跳远")
    private Integer longJump;

    @TableField("lj_score")
    @ExcelProperty(index = 20, value = "立定跳远评分")
    private Integer ljScore;

    @TableField("lj_rank")
    @ExcelProperty(index = 21, value = "立定跳远等级")
    private String ljRank;

    @TableField("sit_and_reach")
    @ExcelProperty(index = 22, value = "坐位体前屈")
    private Integer sitAndReach;

    @TableField("sar_score")
    @ExcelProperty(index = 23, value = "坐位体前屈评分")
    private Integer sarScore;

    @TableField("sar_rank")
    @ExcelProperty(index = 24, value = "坐位体前屈等级")
    private String sarRank;

    @TableField("s_800m")
    @ExcelProperty(index = 25, value = "800米跑")
    private String s800m;

    @TableField("s_800m_score")
    @ExcelProperty(index = 26, value = "800米跑评分")
    private Integer s800mScore;

    @TableField("s_800m_rank")
    @ExcelProperty(index = 27, value = "800米跑等级")
    private String s800mRank;

    @TableField("s_1000m")
    @ExcelProperty(index = 29, value = "1000米跑")
    private String s1000m;

    @TableField("s_1000m_score")
    @ExcelProperty(index = 30, value = "1000米跑评分")
    private Integer s1000mScore;

    @TableField("s_1000m_rank")
    @ExcelProperty(index = 31, value = "1000米跑等级")
    private String s1000mRank;

    @TableField("sit_up")
    @ExcelProperty(index = 33, value = "一分钟仰卧起坐")
    private Integer sitUp;

    @TableField("su_score")
    @ExcelProperty(index = 34, value = "一分钟仰卧起坐评分")
    private Integer suScore;

    @TableField("su_rank")
    @ExcelProperty(index = 35, value = "一分钟仰卧起坐等级")
    private String suRank;

    @TableField("pull_up")
    @ExcelProperty(index = 37, value = "引体向上")
    private Integer pullUp;

    @TableField("pu_score")
    @ExcelProperty(index = 38, value = "引体向上评分")
    private Integer puScore;

    @TableField("pu_rank")
    @ExcelProperty(index = 39, value = "引体向上等级")
    private String puRank;

    @TableField("standard_score")
    @ExcelProperty(index = 41, value = "标准分")
    private Float standardScore;

    @TableField("add_score")
    @ExcelProperty(index =42, value = "附加分")
    private Float addScore;

    @TableField("total_score")
    @ExcelProperty(index = 43, value = "总分")
    private Float totalScore;

    @TableField("total_rank")
    @ExcelProperty(index = 44, value = "总分等级")
    private String totalRank;
//Convert data 35594 to class java.time.LocalDate error
    @ExcelProperty(index = 45, value = "日期")
    private String date;


}
