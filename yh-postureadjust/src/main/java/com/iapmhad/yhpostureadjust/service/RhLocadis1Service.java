package com.iapmhad.yhpostureadjust.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.yhpostureadjust.entity.RhLocadis1Entity;
import com.iapmhad.yhpostureadjust.entity.RhfLocastanEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author wtzang
 * @email w_t_zang1016@163.com
 * @date 2022-10-17 18:27:31
 */
public interface RhLocadis1Service extends IService<RhLocadis1Entity> {
    List<RhLocadis1Entity> getLi(int id);
    PageUtils queryPage(Map<String, Object> params);
}

