package com.hjy.service;

import com.hjy.pojo.SuggestionClassify;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hjy
 * @since 2022-04-13
 */
public interface ISuggestionClassifyService extends IService<SuggestionClassify> {

    String getSug(int parseInt);

    boolean changeSug(SuggestionClassify suggestionClassify);
}
