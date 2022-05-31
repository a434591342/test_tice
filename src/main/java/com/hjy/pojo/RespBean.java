package com.hjy.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 * User: Haojunyu
 * Date: 2021/3/27
 * Time: 15:15
 * Description: 公共返回对象           lombok注解：data是表明是类，无参构造，全参数构造
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespBean {
    //状态码
    private long code;
    //提示信息
    private String message;
    //返回对象
    private Object obj;


    //定义成功返回

    /**
     * 成功返回
     * @param message
     * @return
     */
    public static RespBean success(String message){
        return new RespBean(200,message,null);
    }

    /**
     * 成功返回（带对象）
     * @param message
     * @param obj
     * @return
     */
    public static RespBean success(String message, Object obj){
        return new RespBean(200,message,obj);
    }

    /**
     * 失败返回信息
     * @param message
     * @return
     */
    public static RespBean error(String message){
        return new RespBean(500,message,null);
    }


    /**
     * 失败返回信息2（带对象）
     * @param message
     * @param obj
     * @return
     */
    public static RespBean error(String message, Object obj){
        return new RespBean(500,message,obj);
    }

}