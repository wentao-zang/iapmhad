package com.iapmhad.yhpostureadjust.dao;

import com.iapmhad.yhpostureadjust.entity.RhLocastan1Entity;
import com.iapmhad.yhpostureadjust.entity.RhLocastan2Entity;
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
public interface RhLocastan2Dao extends BaseMapper<RhLocastan2Entity> {
    List<RhLocastan2Entity> getLi(int id);
}
