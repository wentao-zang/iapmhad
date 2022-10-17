package com.iapmhad.yhpostureadjust.dao;

import com.iapmhad.yhpostureadjust.entity.RhLocadis2Entity;
import com.iapmhad.yhpostureadjust.entity.RhLocadis3Entity;
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
public interface RhLocadis3Dao extends BaseMapper<RhLocadis3Entity> {
    List<RhLocadis3Entity> getLi(int id);
}
