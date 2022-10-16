package com.iapmhad.yhpostureadjust.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.yhpostureadjust.entity.RsBasedisEntity;
import com.iapmhad.yhpostureadjust.entity.RsBasestanEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author wtzang
 * @email w_t_zang1016@163.com
 * @date 2022-10-11 15:11:17
 */
public interface RsBasestanService extends IService<RsBasestanEntity> {
    List<RsBasestanEntity> getLi(int id);
    PageUtils queryPage(Map<String, Object> params);
}

