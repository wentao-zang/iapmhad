package com.iapmhad.yhpostureadjust.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.yhpostureadjust.entity.LhfLocadisEntity;
import com.iapmhad.yhpostureadjust.entity.LhfLocastanEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author wtzang
 * @email w_t_zang1016@163.com
 * @date 2022-10-17 18:27:30
 */
public interface LhfLocastanService extends IService<LhfLocastanEntity> {
    List<LhfLocastanEntity> getLi(int id);
    PageUtils queryPage(Map<String, Object> params);
}

