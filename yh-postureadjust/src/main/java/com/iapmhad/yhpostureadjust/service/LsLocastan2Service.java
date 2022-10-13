package com.iapmhad.yhpostureadjust.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.yhpostureadjust.entity.LsLocastan2Entity;
import com.iapmhad.yhpostureadjust.entity.LxLocastan2Entity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author wtzang
 * @email w_t_zang1016@163.com
 * @date 2022-10-11 15:11:17
 */
public interface LsLocastan2Service extends IService<LsLocastan2Entity> {
    List<LsLocastan2Entity> getLi(int id);
    PageUtils queryPage(Map<String, Object> params);
}

