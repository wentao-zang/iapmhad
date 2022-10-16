package com.iapmhad.yhpostureadjust.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.yhpostureadjust.entity.LsBasestanEntity;
import com.iapmhad.yhpostureadjust.entity.LsLocadis1Entity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author wtzang
 * @email w_t_zang1016@163.com
 * @date 2022-10-11 15:11:17
 */
public interface LsBasestanService extends IService<LsBasestanEntity> {
    List<LsBasestanEntity> getLi(int id);
    PageUtils queryPage(Map<String, Object> params);
}

