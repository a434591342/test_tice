package com.hjy.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * Created with IntelliJ IDEA.
 * User: Haojunyu
 * Date: 2021/3/28
 * Time: 13:53
 * Description: 用户登录实体类
 */
//lombok注解
@Data
//自动的给model bean实现equals方法和hashcode方法。
@EqualsAndHashCode(callSuper = false)
//用于返回当前对象
@Accessors(chain = true)
//这个是swagger注解，因为要用到前后端分离
@ApiModel(value = "AdminLogin对象",description = "")

public class AdminLoginParam {
    @ApiModelProperty(value = "用户名",required = true)
    private double username;
    @ApiModelProperty(value = "密码",required = true)
    private String password;
    @ApiModelProperty(value = "验证码",required = true)
    private String code;
    @ApiModelProperty(value = "角色",required = true)
    private String role;
}