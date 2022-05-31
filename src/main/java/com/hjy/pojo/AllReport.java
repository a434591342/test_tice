package com.hjy.pojo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="report对象", description="")
public class AllReport {
    private Integer report_id;
    private String year;
    private String reportName;
    private Integer test_score_id;
}
