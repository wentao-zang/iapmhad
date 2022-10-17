package com.iapmhad.yhpostureadjust.dao;

import com.iapmhad.yhpostureadjust.entity.LhLocadis1Entity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iapmhad.yhpostureadjust.entity.LhfLocastanEntity;
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
public interface LhLocadis1Dao extends BaseMapper<LhLocadis1Entity> {
    List<LhLocadis1Entity> getLi(int id);
}
