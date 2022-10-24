package com.iapmhad.jydbjdj.dao;

import com.iapmhad.jydbjdj.entity.JyLocadisEntity;
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
public interface JyLocadisDao extends BaseMapper<JyLocadisEntity> {
    List<JyLocadisEntity> getLi(int id);
}
