package com.iapmhad.ame_hdym.dao;

import com.iapmhad.ame_hdym.entity.AxisinfoEntity;
import com.iapmhad.ame_hdym.entity.SpinfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author wtzang
 * @email w_t_zang1016@163.com
 * @date 2022-09-15 11:02:30
 */
@Mapper
public interface SpinfoDao extends BaseMapper<SpinfoEntity> {
    List<SpinfoEntity> getLi(int id);
}
