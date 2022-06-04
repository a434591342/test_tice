package com.hjy.service.impl;

import com.hjy.pojo.SuggestionClassify;
import com.hjy.mapper.SuggestionClassifyMapper;
import com.hjy.service.ISuggestionClassifyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hjy
 * @since 2022-04-13
 */
@Service
public class SuggestionClassifyServiceImpl extends ServiceImpl<SuggestionClassifyMapper, SuggestionClassify> implements ISuggestionClassifyService {
    @Autowired
    private SuggestionClassifyMapper suggestionClassifyMapper;
    @Override
    public String getSug(int parseInt) {
        return suggestionClassifyMapper.selectSug(parseInt);
    }

    @Override
    public boolean changeSug(SuggestionClassify suggestionClassify) {

        return suggestionClassifyMapper.changeSug(suggestionClassify);
    }
}
