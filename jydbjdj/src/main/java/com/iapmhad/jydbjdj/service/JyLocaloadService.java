package com.iapmhad.jydbjdj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.jydbjdj.entity.JyLocadisEntity;
import com.iapmhad.jydbjdj.entity.JyLocaloadEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author wtzang
 * @email w_t_zang1016@163.com
 * @date 2022-10-20 15:50:00
 */
public interface JyLocaloadService extends IService<JyLocaloadEntity> {
    List<JyLocaloadEntity> getLi(int id);
    PageUtils queryPage(Map<String, Object> params);
}

