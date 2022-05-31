package com.hjy.service.impl;

import com.hjy.pojo.Major;
import com.hjy.mapper.MajorMapper;
import com.hjy.pojo.RespBean;
import com.hjy.service.IMajorService;
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
public class MajorServiceImpl extends ServiceImpl<MajorMapper, Major> implements IMajorService {

    @Autowired
    private MajorMapper majorMapper;
    @Override
    public Major selectById(Integer majorId) {
        return majorMapper.selectById(majorId);

    }

    @Override
    public List<String> selectAllName() {

        return majorMapper.selectAllName();
    }

    @Override
    public RespBean selectMajor(String academy) {
        List<String> majors = majorMapper.selectByAcademy(academy);
        if (majors.size()!=0){
            return RespBean.success("查询成功",majors);
        }else return RespBean.error("查询失败");
    }

}
