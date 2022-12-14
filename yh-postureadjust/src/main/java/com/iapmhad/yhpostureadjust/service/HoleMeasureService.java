package com.iapmhad.yh_postureadjust.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.yh_postureadjust.entity.HoleMeasureEntity;
import com.iapmhad.yhpostureadjust.entity.LhfLocadisEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author wtzang
 * @email w_t_zang1016@163.com
 * @date 2022-12-13 21:37:47
 */
public interface HoleMeasureService extends IService<HoleMeasureEntity> {
    List<HoleMeasureEntity> getLi(int id);
    PageUtils queryPage(Map<String, Object> params);
}

