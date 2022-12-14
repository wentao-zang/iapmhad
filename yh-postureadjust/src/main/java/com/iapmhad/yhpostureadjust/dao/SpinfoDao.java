package com.iapmhad.yh_postureadjust.dao;

import com.iapmhad.yh_postureadjust.entity.SpinfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author wtzang
 * @email w_t_zang1016@163.com
 * @date 2022-12-13 21:37:47
 */
@Mapper
public interface SpinfoDao extends BaseMapper<SpinfoEntity> {
    List<SpinfoEntity> getLi(int id);
}
