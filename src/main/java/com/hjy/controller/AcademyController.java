package com.hjy.controller;


import com.hjy.pojo.Academy;
import com.hjy.service.impl.AcademyServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hjy
 * @since 2022-04-13
 */
@RestController
@RequestMapping("/academy")
public class AcademyController {

    @Autowired
    private AcademyServiceImpl academyService;


    @GetMapping("/list")
    @ApiOperation(value = "列出所有")
    public List<Academy> getAll(){
        return academyService.list();
    }

}
