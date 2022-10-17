package com.iapmhad.yhpostureadjust.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.yhpostureadjust.entity.LhfLocadisEntity;
import com.iapmhad.yhpostureadjust.entity.LsLocadis1Entity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author wtzang
 * @email w_t_zang1016@163.com
 * @date 2022-10-17 18:27:31
 */
public interface LhfLocadisService extends IService<LhfLocadisEntity> {
    List<LhfLocadisEntity> getLi(int id);
    PageUtils queryPage(Map<String, Object> params);
}

