package com.iapmhad.yhpostureadjust.dao;

import com.iapmhad.yhpostureadjust.entity.LhLocastan3Entity;
import com.iapmhad.yhpostureadjust.entity.RhfLocadisEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author wtzang
 * @email w_t_zang1016@163.com
 * @date 2022-10-17 18:27:31
 */
@Mapper
public interface RhfLocadisDao extends BaseMapper<RhfLocadisEntity> {
    List<RhfLocadisEntity> getLi(int id);
}
