package com.iapmhad.yhpostureadjust.dao;

import com.iapmhad.yhpostureadjust.entity.LhfLocadisEntity;
import com.iapmhad.yhpostureadjust.entity.LhfLocastanEntity;
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
public interface LhfLocastanDao extends BaseMapper<LhfLocastanEntity> {
    List<LhfLocastanEntity> getLi(int id);
}
