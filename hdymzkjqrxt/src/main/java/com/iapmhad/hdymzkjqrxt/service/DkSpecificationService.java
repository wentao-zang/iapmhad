package com.iapmhad.hdymzkjqrxt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.hdymzkjqrxt.entity.DkSpecificationEntity;

import java.util.Map;
import java.util.List;
/**
 * 刀库规格信息表
 *
 * @author ynd
 * @email 3361725156@qq.com
 * @date 2022-07-04 09:04:25
 */
public interface DkSpecificationService extends IService<DkSpecificationEntity> {

    PageUtils queryPage(Map<String, Object> params);
    List<DkSpecificationEntity> getLi(int id);
        DkSpecificationEntity getLast();
}

