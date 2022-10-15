package com.iapmhad.yhmachinedrilling.dao;

import com.iapmhad.yhmachinedrilling.entity.AxisinfoEntity;
import com.iapmhad.yhmachinedrilling.entity.SpinfoEntity;
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
public interface SpinfoDao extends BaseMapper<SpinfoEntity> {
    List<SpinfoEntity> getLi(int id);
}
