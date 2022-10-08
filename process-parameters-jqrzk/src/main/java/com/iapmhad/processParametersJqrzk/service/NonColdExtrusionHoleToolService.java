package com.iapmhad.processParametersJqrzk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.processParametersJqrzk.entity.NonColdExtrusionHoleToolEntity;

import java.util.Map;

/**
 * 
 *
 * @author ynd
 * @email 3361725156@qq.com
 * @date 2022-05-27 13:13:31
 */
public interface NonColdExtrusionHoleToolService extends IService<NonColdExtrusionHoleToolEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

