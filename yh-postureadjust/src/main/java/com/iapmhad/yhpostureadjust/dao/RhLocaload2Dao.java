package com.iapmhad.yhpostureadjust.dao;

import com.iapmhad.yhpostureadjust.entity.RhLocaload1Entity;
import com.iapmhad.yhpostureadjust.entity.RhLocaload2Entity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author wtzang
 * @email w_t_zang1016@163.com
 * @date 2022-10-19 22:02:25
 */
@Mapper
public interface RhLocaload2Dao extends BaseMapper<RhLocaload2Entity> {
    List<RhLocaload2Entity> getLi(int id);
}
