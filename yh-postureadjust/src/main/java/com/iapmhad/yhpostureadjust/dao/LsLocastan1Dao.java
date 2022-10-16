package com.iapmhad.yhpostureadjust.dao;

import com.iapmhad.yhpostureadjust.entity.LsLocaload2Entity;
import com.iapmhad.yhpostureadjust.entity.LsLocastan1Entity;
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
public interface LsLocastan1Dao extends BaseMapper<LsLocastan1Entity> {
    List<LsLocastan1Entity> getLi(int id);
}
