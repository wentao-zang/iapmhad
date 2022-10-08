package com.iapmhad.hdymzkjqrxt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.hdymzkjqrxt.entity.ZkzdzxqSpecificationEntity;

import java.util.Map;
import java.util.List;
/**
 * 制孔终端执行器规格信息表
 *
 * @author ynd
 * @email 3361725156@qq.com
 * @date 2022-07-04 09:04:25
 */
public interface ZkzdzxqSpecificationService extends IService<ZkzdzxqSpecificationEntity> {

    PageUtils queryPage(Map<String, Object> params);
    List<ZkzdzxqSpecificationEntity> getLi(int id);
        ZkzdzxqSpecificationEntity getLast();
}

