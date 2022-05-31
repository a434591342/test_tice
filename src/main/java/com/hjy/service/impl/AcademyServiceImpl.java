package com.hjy.service.impl;

import com.hjy.pojo.Academy;
import com.hjy.mapper.AcademyMapper;
import com.hjy.service.IAcademyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hjy
 * @since 2022-04-13
 */
@Service
public class AcademyServiceImpl extends ServiceImpl<AcademyMapper, Academy> implements IAcademyService {

    @Autowired
    private AcademyMapper academyMapper;

    @Override
    public String selectNameById(Integer academyId) {
        return academyMapper.selectNameById(academyId);
    }

    @Override
    public List<String> selectAllName() {
        return academyMapper.selectNames();
    }
}
