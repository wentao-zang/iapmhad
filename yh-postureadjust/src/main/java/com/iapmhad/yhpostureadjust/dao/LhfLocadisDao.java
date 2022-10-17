package com.iapmhad.yhpostureadjust.dao;

import com.iapmhad.yhpostureadjust.entity.LhfLocadisEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iapmhad.yhpostureadjust.entity.LsLocadis1Entity;
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
public interface LhfLocadisDao extends BaseMapper<LhfLocadisEntity> {
    List<LhfLocadisEntity> getLi(int id);
}
