package com.iapmhad.hdymzkjqrxt.dao;

import com.iapmhad.hdymzkjqrxt.entity.YdptSpecificationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
/**
 * 移动平台规格信息表
 * 
 * @author ynd
 * @email 3361725156@qq.com
 * @date 2022-07-04 09:04:25
 */
@Mapper
public interface YdptSpecificationDao extends BaseMapper<YdptSpecificationEntity> {
    public List<YdptSpecificationEntity> getLi(int id);
    public YdptSpecificationEntity getLast();
}
