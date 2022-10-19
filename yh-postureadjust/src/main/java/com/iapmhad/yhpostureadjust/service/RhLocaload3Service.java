package com.iapmhad.yhpostureadjust.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.yhpostureadjust.entity.RhLocaload1Entity;
import com.iapmhad.yhpostureadjust.entity.RhLocaload3Entity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author wtzang
 * @email w_t_zang1016@163.com
 * @date 2022-10-19 22:02:25
 */
public interface RhLocaload3Service extends IService<RhLocaload3Entity> {
    List<RhLocaload3Entity> getLi(int id);
    PageUtils queryPage(Map<String, Object> params);
}

