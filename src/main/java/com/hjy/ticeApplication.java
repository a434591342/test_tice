package com.hjy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created with IntelliJ IDEA.
 * User: Haojunyu
 * Date: 2021/4/14
 * Time: 11:22
 * Description: No Description
 */
@SpringBootApplication
@MapperScan("com.hjy.mapper")
public class ticeApplication {
    public static void main(String[] args) {
        SpringApplication.run(ticeApplication.class,args);
    }

}