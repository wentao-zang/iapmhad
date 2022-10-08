package com.iapmhad.hdymzkjqrxt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.hdymzkjqrxt.entity.JgzzSpecificationEntity;

import java.util.Map;
import java.util.List;
/**
 * 
 *
 * @author ynd
 * @email 3361725156@qq.com
 * @date 2022-07-04 09:04:25
 */
public interface JgzzSpecificationService extends IService<JgzzSpecificationEntity> {

    PageUtils queryPage(Map<String, Object> params);
    List<JgzzSpecificationEntity> getLi(int id);
        JgzzSpecificationEntity getLast();
}

