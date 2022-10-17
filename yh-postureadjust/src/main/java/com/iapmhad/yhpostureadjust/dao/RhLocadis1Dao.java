package com.iapmhad.yhpostureadjust.dao;

import com.iapmhad.yhpostureadjust.entity.RhLocadis1Entity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iapmhad.yhpostureadjust.entity.RhfLocastanEntity;
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
public interface RhLocadis1Dao extends BaseMapper<RhLocadis1Entity> {
    List<RhLocadis1Entity> getLi(int id);
}
