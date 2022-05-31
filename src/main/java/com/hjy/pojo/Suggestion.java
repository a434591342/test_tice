package com.hjy.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
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
@ApiModel(value="Suggestion对象", description="")
public class Suggestion implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "suggestion_id", type = IdType.AUTO)
    private Integer suggestionId;

    @TableField("teacher_sug")
    private String teacherSug;

    @TableField("class_sug")
    private String classSug;

    @TableField("test_score_id")
    private Integer testScoreId;


}
