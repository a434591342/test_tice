package com.hjy.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("student_info")
@ApiModel(value="StudentInfo对象", description="")
public class StudentInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("school_number")
    private Integer schoolNumber;

    private String name;

    private String password;

    private Integer sex;

    @TableField("class_id")
    private Integer classId;

    @TableField("class_name")
    private String className;

    @TableField("nation_id")
    private Integer nationId;

    @TableField("major_id")
    private Integer majorId;

    @TableField("city_id")
    private Integer cityId;
    @TableField("note")
    private String note;


}
