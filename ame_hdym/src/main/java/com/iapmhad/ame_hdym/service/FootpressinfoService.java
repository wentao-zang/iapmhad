package com.iapmhad.ame_hdym.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.ame_hdym.entity.FootpressinfoEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author wtzang
 * @email w_t_zang1016@163.com
 * @date 2022-09-15 11:02:31
 */
public interface FootpressinfoService extends IService<FootpressinfoEntity> {
    List<FootpressinfoEntity> getLi(int id);
    PageUtils queryPage(Map<String, Object> params);
}

