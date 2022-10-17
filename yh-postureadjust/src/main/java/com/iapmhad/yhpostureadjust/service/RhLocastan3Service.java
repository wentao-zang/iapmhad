package com.iapmhad.yhpostureadjust.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.yhpostureadjust.entity.RhLocastan2Entity;
import com.iapmhad.yhpostureadjust.entity.RhLocastan3Entity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author wtzang
 * @email w_t_zang1016@163.com
 * @date 2022-10-17 18:27:30
 */
public interface RhLocastan3Service extends IService<RhLocastan3Entity> {
    List<RhLocastan3Entity> getLi(int id);
    PageUtils queryPage(Map<String, Object> params);
}

