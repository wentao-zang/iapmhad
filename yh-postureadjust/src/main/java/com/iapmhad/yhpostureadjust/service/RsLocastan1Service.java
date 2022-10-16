package com.iapmhad.yhpostureadjust.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.yhpostureadjust.entity.RsLocaload2Entity;
import com.iapmhad.yhpostureadjust.entity.RsLocastan1Entity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author wtzang
 * @email w_t_zang1016@163.com
 * @date 2022-10-11 15:11:17
 */
public interface RsLocastan1Service extends IService<RsLocastan1Entity> {
    List<RsLocastan1Entity> getLi(int id);
    PageUtils queryPage(Map<String, Object> params);
}

