package com.iapmhad.hdymzkjqrxt.dao;

import com.iapmhad.hdymzkjqrxt.entity.HdymjqrzkxtStructureEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
/**
 * 
 * 
 * @author ynd
 * @email 3361725156@qq.com
 * @date 2022-07-04 09:04:25
 */
@Mapper
public interface HdymjqrzkxtStructureDao extends BaseMapper<HdymjqrzkxtStructureEntity> {
    public List<HdymjqrzkxtStructureEntity> getLi(int id);
    public HdymjqrzkxtStructureEntity getLast();
}
