package com.iapmhad.jydbjdj.dao;

import com.iapmhad.jydbjdj.entity.RwLocadisEntity;
import com.iapmhad.jydbjdj.entity.RwLocaloadEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author wtzang
 * @email w_t_zang1016@163.com
 * @date 2022-10-20 15:50:00
 */
@Mapper
public interface RwLocaloadDao extends BaseMapper<RwLocaloadEntity> {
    List<RwLocaloadEntity> getLi(int id);
}
