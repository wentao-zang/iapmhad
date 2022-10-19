package com.iapmhad.yhpostureadjust.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.yhpostureadjust.entity.RhLocaload1Entity;
import com.iapmhad.yhpostureadjust.entity.RhLocaload2Entity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author wtzang
 * @email w_t_zang1016@163.com
 * @date 2022-10-19 22:02:25
 */
public interface RhLocaload2Service extends IService<RhLocaload2Entity> {
    List<RhLocaload2Entity> getLi(int id);
    PageUtils queryPage(Map<String, Object> params);
}

