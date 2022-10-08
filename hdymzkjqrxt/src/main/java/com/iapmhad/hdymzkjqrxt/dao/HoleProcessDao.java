package com.iapmhad.hdymzkjqrxt.dao;

import com.iapmhad.hdymzkjqrxt.entity.HoleProcessEntity;
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
public interface HoleProcessDao extends BaseMapper<HoleProcessEntity> {
    public List<HoleProcessEntity> getLi(int id);
    public HoleProcessEntity getLast();
}
