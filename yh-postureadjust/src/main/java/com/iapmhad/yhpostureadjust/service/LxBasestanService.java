package com.iapmhad.yhpostureadjust.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.yhpostureadjust.entity.LsLocastan1Entity;
import com.iapmhad.yhpostureadjust.entity.LxBasestanEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author wtzang
 * @email w_t_zang1016@163.com
 * @date 2022-10-11 15:11:17
 */
public interface LxBasestanService extends IService<LxBasestanEntity> {
    List<LxBasestanEntity> getLi(int id);
    PageUtils queryPage(Map<String, Object> params);
}

