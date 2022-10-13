package com.iapmhad.yhmachinedrilling.dao;

import com.iapmhad.yhmachinedrilling.entity.AxisinfoEntity;
import com.iapmhad.yhmachinedrilling.entity.HoleMeasureEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author wtzang
 * @email w_t_zang1016@163.com
 * @date 2022-10-11 15:15:34
 */
@Mapper
public interface HoleMeasureDao extends BaseMapper<HoleMeasureEntity> {
    List<HoleMeasureEntity> getLi(int id);
}
