package com.hjy.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

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
@ApiModel(value="Download对象", description="")
public class Download implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("download_id")
    private Integer downloadId;

    @TableField("download_name")
    private String downloadName;

    @TableField("download_content")
    private String downloadContent;
    @JsonFormat(pattern = "MM-dd",timezone = "GMT+8")
    private LocalDateTime time;

    @TableField("download_file_name")
    private String downloadFileName;

}
