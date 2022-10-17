package com.iapmhad.yhpostureadjust.dao;

import com.iapmhad.yhpostureadjust.entity.RhfLocadisEntity;
import com.iapmhad.yhpostureadjust.entity.RhfLocastanEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author wtzang
 * @email w_t_zang1016@163.com
 * @date 2022-10-17 18:27:30
 */
@Mapper
public interface RhfLocastanDao extends BaseMapper<RhfLocastanEntity> {
    List<RhfLocastanEntity> getLi(int id);
}
