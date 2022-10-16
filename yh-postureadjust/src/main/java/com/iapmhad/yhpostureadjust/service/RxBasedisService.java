package com.iapmhad.yhpostureadjust.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.yhpostureadjust.entity.RsLocastan2Entity;
import com.iapmhad.yhpostureadjust.entity.RxBasedisEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author wtzang
 * @email w_t_zang1016@163.com
 * @date 2022-10-11 15:11:17
 */
public interface RxBasedisService extends IService<RxBasedisEntity> {
    List<RxBasedisEntity> getLi(int id);
    PageUtils queryPage(Map<String, Object> params);
}

