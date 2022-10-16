package com.iapmhad.yhpostureadjust.dao;

import com.iapmhad.yhpostureadjust.entity.LqLocadisEntity;
import com.iapmhad.yhpostureadjust.entity.LqLocastanEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author wtzang
 * @email w_t_zang1016@163.com
 * @date 2022-10-11 15:11:17
 */
@Mapper
public interface LqLocastanDao extends BaseMapper<LqLocastanEntity> {
    List<LqLocastanEntity> getLi(int id);
}
