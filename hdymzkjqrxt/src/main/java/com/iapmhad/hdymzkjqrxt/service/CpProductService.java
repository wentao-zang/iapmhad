package com.iapmhad.hdymzkjqrxt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.hdymzkjqrxt.entity.CpProductEntity;

import java.util.Map;
import java.util.List;
/**
 * 
 *
 * @author ynd
 * @email 3361725156@qq.com
 * @date 2022-07-04 09:04:25
 */
public interface CpProductService extends IService<CpProductEntity> {

    PageUtils queryPage(Map<String, Object> params);
    List<CpProductEntity> getLi(int id);
        CpProductEntity getLast();
}

