package com.iapmhad.yhpostureadjust.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.yhpostureadjust.entity.LhLocadis1Entity;
import com.iapmhad.yhpostureadjust.entity.LhLocadis2Entity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author wtzang
 * @email w_t_zang1016@163.com
 * @date 2022-10-17 18:27:31
 */
public interface LhLocadis2Service extends IService<LhLocadis2Entity> {
    List<LhLocadis2Entity> getLi(int id);
    PageUtils queryPage(Map<String, Object> params);
}

